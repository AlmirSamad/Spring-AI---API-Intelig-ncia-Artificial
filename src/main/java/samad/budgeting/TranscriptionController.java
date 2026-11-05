package samad.budgeting;


import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/api")
public class TranscriptionController {

    private final TranscriptionModel transcriptionModel;
    private final ResourceLoader resourceLoader;

    public TranscriptionController(TranscriptionModel transcriptionModel, ResourceLoader resourceLoader){
        this.transcriptionModel = transcriptionModel;
        this.resourceLoader = resourceLoader;
    }

    @PostMapping(value = "/transcribe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     String transcrib(@RequestParam("file") MultipartFile file){
        var resource = file.getResource();

        return transcriptionModel.transcribe(resource);

    }
}
