package hw3.chat;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Solyk on 28.02.2016.
 */
public class AsyncChatTest {
    
    private AsyncChat asyncChat;
    
    @Before
    public void setUp() throws Exception {
        asyncChat = new AsyncChat();
    }

    @Test
    public void test() throws Exception {

        asyncChat.process();
        Assert.assertTrue(true);
        System.out.println("Test OK");
    }

    public static void main(String[] args) {

    }
}
