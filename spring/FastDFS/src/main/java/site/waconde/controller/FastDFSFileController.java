package site.waconde.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.waconde.service.impl.FastDFSFileServiceImpl;

@Controller
@RequestMapping("/")
public class FastDFSFileController {
    private static Logger logger = LoggerFactory.getLogger(FastDFSFileController.class);
    @Autowired
    private FastDFSFileServiceImpl fastDFSFileServiceImpl;
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

    @PostMapping("upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            String path = fastDFSFileServiceImpl.saveFile(file);
            redirectAttributes.addFlashAttribute("message",
                                                 "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("path", "file path url '" + path + "'");
        } catch (Exception e) {
            logger.error("upload file failed", e);
        }
        return "redirect:/uploadResult";
    }
}
