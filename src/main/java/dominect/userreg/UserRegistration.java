package dominect.userreg;

// User Registration
// Server address: gameserver.ist.tugraz.at
// IP(prefered):   129.27.202.46
// Port:           80
// TODO: Connects to the server but fails to pass RPC

import dom.UserInfo;
import dom.UserRegFeed;
import dom.UserRegistrationGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;



public class UserRegistration {

    // Insert your data here
    String email = "dzenis.kajtazovic@student.tugraz.at";
    String fullname = "Dzenis Kajtazovic";
    String matrNr = "01231661";
    String secret = "biliciku";

    private static final Logger logger = Logger.getLogger(UserRegistration.class.getName());
    private final UserRegistrationGrpc.UserRegistrationBlockingStub stub;

    public UserRegistration(Channel channel) {

        stub = UserRegistrationGrpc.newBlockingStub(channel);
    }

    public void register() {
        logger.info("Registring " + fullname + " ...");
        UserInfo request = UserInfo.newBuilder()
                .setEmail(email)
                .setFullname(fullname)
                .setMatrNr(matrNr)
                .setSecret(secret).build();
        UserRegFeed response;
        try {
        response = stub.userRegistration(request);
        System.out.println(response);
        } catch (StatusRuntimeException e) {

            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        System.out.println(response);
       // logger.info("Greeting: " + response.getMessage());
    }

    public static void main(String[] args) throws Exception {

        String target = "129.27.202.46:80";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        try {
            UserRegistration client = new UserRegistration(channel);
            client.register();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

