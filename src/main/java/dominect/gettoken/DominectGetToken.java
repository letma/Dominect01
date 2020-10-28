// User Registration
// Server address: gameserver.ist.tugraz.at
// IP(prefered):   129.27.202.46
// Port:           80
// TODO: Connects to the server but fails to pass RPC
package dominect.gettoken;

import dom.GetToken;
import dom.GetTokenResponse;
import dom.GetUserTokenGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DominectGetToken {

    // Insert your data here
    // String email = "dzenis.kajtazovic@student.tugraz.at";
    // String fullname = "Dzenis Kajtazovic";
    String matrNr = "01231661";
    String secret = "biliciku";

    private static final Logger logger = Logger.getLogger(DominectGetToken.class.getName());
    private final GetUserTokenGrpc.GetUserTokenBlockingStub stub;

    public DominectGetToken(Channel channel) {
        stub = GetUserTokenGrpc.newBlockingStub(channel);
    }

    public void gettoken() {
        logger.info("Getting token for " + matrNr + " ...");
        GetToken request = GetToken.newBuilder()
                .setMatrNr(matrNr)
                .setSecret(secret).build();
        GetTokenResponse response;
        response = stub.getUserToken(request);
        System.out.println(response);
        // logger.info("Greeting: " + response.getMessage());
    }

    public static void main(String[] args) throws Exception {

        String target = "129.27.202.46:80";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        try {
            DominectGetToken client = new DominectGetToken(channel);
           client.gettoken();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

