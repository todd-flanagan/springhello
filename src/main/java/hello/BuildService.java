package hello;

import java.util.List;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class BuildService{

    public List<String> listAllBuilds(){

      List<String> builds = Arrays.<String>asList(new String[]{"b1, b2"});

      return builds;
    }

}
