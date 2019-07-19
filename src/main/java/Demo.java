import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

/**
 * @author wangb
 * @version 1.0.0
 * @since 2019/7/17
 */
public class Demo {

    private static final  GoEasy goEasy=new GoEasy("rest-hangzhou.goeasy.io","BC-a0e4f9b9b7a5460caf268df92584fe83");

    public static void main(String[] args) {
        String[] names = {"小米","小明","小红","小胖"};
        for(String name:names){
            publish("userId","你好，"+name+"!");
        }
    }

    private static void publish(String channel,String message){
        goEasy.publish(channel,message,new PublishListener(){
            @Override
            public void onSuccess()
            {
                System.out.println("Publish Success");
            }

            @Override
            public void onFailed(GoEasyError error)
            {
                System.out.println("Publish Failed"+error.getCode()+error.getContent());
            }
        });
    }
}
