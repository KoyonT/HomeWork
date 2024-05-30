    package org.example;

    import ru.pflb.mq.dummy.implementation.ConnectionImpl;
    import ru.pflb.mq.dummy.implementation.DestinationImpl;
    import ru.pflb.mq.dummy.implementation.ProducerImpl;
    import ru.pflb.mq.dummy.interfaces.Connection;
    import ru.pflb.mq.dummy.interfaces.Session;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) {
  try {
           Connection connection = new ConnectionImpl();
           Session session = connection.createSession(true);
           DestinationImpl destination = new DestinationImpl("MyQueue");
           ProducerImpl producer =  new ProducerImpl(destination);
           List<String> list = new ArrayList<>();
           list.add("Четыре");
           list.add("Пять");
           list.add("Шесть");
      for (String s : list) {
          producer.send(s);
          TimeUnit.SECONDS.sleep(2);
      }
           session.close();
           connection.close();
       }
       catch (Exception e) {
           e.printStackTrace();
       }
        }
    }


