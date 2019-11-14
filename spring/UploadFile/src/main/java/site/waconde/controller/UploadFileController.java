package site.waconde.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class UploadFileController {
    @Value("${upload.folder}")
    private String UPLOADED_FOLDER;

    @GetMapping("upload")
    public String upload() {
        return "upload";
    }

    @GetMapping("uploadResult")
    public String uploadResult(@ModelAttribute("message") String message) {
        return "uploadResult";
    }

    @PostMapping("uploadSingleFile")
    public String uploadSingleFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER, file.getOriginalFilename());
            if (Files.notExists(path.getParent())) {
                System.out.println("create a new directory");
                Files.createDirectories(path.getParent());
            }
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadResult";
    }
}
