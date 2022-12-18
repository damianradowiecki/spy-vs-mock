package pl.damianradowiecki;

import pl.damianradowiecki.model.From;
import pl.damianradowiecki.model.To;

/**
 * That is a very simple example of difference between Mock and Spy
 * implemented using pure Java language.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("------------------");
        mockTesting();
        System.out.println("------------------");
        spyTesting();
        System.out.println("------------------");
    }

    public static void mockTesting(){
        ConnectionMock mock = new ConnectionMock();
        mock.stub("getFrom", (a) -> new From("127.0.0.0:80"));

        if(mock.getFrom() != null) {
            System.out.println("Successfully applied stub on ConnectionMock");
        }
    }

    public static void spyTesting(){
        ConnectionImpl connection = new ConnectionImpl(new From("127.0.0.0:80"), new To("127.0.0.0:81"));
        ConnectionSpy connectionSpy = new ConnectionSpy(connection);

        connectionSpy.connect();

        connectionSpy.stub("disconnect", (a) -> null);

        connectionSpy.disconnect();

        if(connectionSpy.isConnected()){
            System.out.println("Successfully applied stub on disconnect method");
        }

        if(connectionSpy.checkHowManyTimesHaveBeenCalled("connect") == 1){
            System.out.println("Successfully checked 'connect' calls count");
        }

        if(connectionSpy.checkHowManyTimesHaveBeenCalled("getFrom") == 0){
            System.out.println("Successfully checked 'getFrom' calls count");
        }
    }
}
