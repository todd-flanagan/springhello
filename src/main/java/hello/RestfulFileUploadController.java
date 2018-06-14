package hello;

import java.io.IOException;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.storage.StorageFileNotFoundException;
import hello.storage.StorageService;


@RestController
public class RestfulFileUploadController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final StorageService storageService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public RestfulFileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }


    @RequestMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");


        //post new file to build table, processed with batch job later
        String ctfName = file.getOriginalFilename().replace(".mltbx",".ctf");
        log.info(String.format("Inserting builds record for %s %s", file.getOriginalFilename(), ctfName));
        String pair[]  = new String[]{file.getOriginalFilename(), ctfName};
        List<Object[]> names = Arrays.<Object []>asList(pair);

        jdbcTemplate.batchUpdate("INSERT INTO builds (toolbox, ctf) VALUES (?,?)", names);


        return "uploaded: " + file.getOriginalFilename();
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
