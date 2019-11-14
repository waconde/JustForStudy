package site.waconde;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.fromMail.addr}")
	private String sender;
	
	/**
	 * 发送普通文本邮件
	 * @param recipient 收件方
	 * @param subject 主题
	 * @param content 内容
	 *
	 * @author side.wang
	 * @since 2019年9月25日
	 */
	public void sendTextMail(String recipient, String subject, String content) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(sender);
		smm.setTo(recipient);
		smm.setSubject(subject);
		smm.setText(content);
		
		try {
			mailSender.send(smm);
			log.info("邮件已发送到：" + recipient);
		} catch (Exception e) {
			log.error("邮件发送失败", e);
		}
	}
	
	/**
	 * 发送html邮件
	 * @param recipient 收件方
	 * @param subject 主题
	 * @param content 内容
	 *
	 * @author side.wang
	 * @since 2019年9月25日
	 */
	public void sendHtmlMail(String recipient, String subject, String content) {
		MimeMessage mm = mailSender.createMimeMessage();
		MimeMessageHelper mmh = null;
		try {
			mmh = new MimeMessageHelper(mm, true);
			mmh.setFrom(sender);
			mmh.setTo(recipient);
			mmh.setSubject(subject);
			mmh.setText(content, true);
			mailSender.send(mm);
			log.info("邮件已发送到：" + recipient);
		} catch (MessagingException e) {
			log.error("邮件发送失败", e);
		}
	}
	
	/**
	 * 发送附件邮件
	 * @param recipient 收件方
	 * @param subject 主题
	 * @param content 内容
	 * @param filepath 文件路径
	 *
	 * @author side.wang
	 * @since 2019年9月25日
	 */
	public void sendAttachmentsMail(String recipient, String subject, String content, String filepath) {
		MimeMessage mm = mailSender.createMimeMessage();
		MimeMessageHelper mmh = null;
		try {
			mmh = new MimeMessageHelper(mm, true);
			mmh.setFrom(sender);
			mmh.setTo(recipient);
			mmh.setSubject(subject);
			mmh.setText(content, true);
			
			FileSystemResource fsr = new FileSystemResource(new File(filepath));
			String filename = filepath.substring(filepath.lastIndexOf(File.separator));
			mmh.addAttachment(filename, fsr);
			
			mailSender.send(mm);
			log.info("邮件已发送到：" + recipient);
		} catch (Exception e) {
			log.error("邮件发送失败", e);
		}
	}
	
	/**
	 * 发送静态资源邮件
	 * @param recipient 收件方
	 * @param subject 主题
	 * @param content 内容
	 * @param filepath 文件路径
	 * @param fileId 文件ID
	 *
	 * @author side.wang
	 * @since 2019年9月25日
	 */
	public void sendInlineResourceMail(String recipient, String subject, String content, String filepath, String fileId) {
		MimeMessage mm = mailSender.createMimeMessage();
		MimeMessageHelper mmh = null;
		try {
			mmh = new MimeMessageHelper(mm, true);
			mmh.setFrom(sender);
			mmh.setTo(recipient);
			mmh.setSubject(subject);
			// 静态资源如图片，需要在这里加个true，才能在邮件中显示静态资源
			mmh.setText(content, true);
			
			FileSystemResource fsr = new FileSystemResource(new File(filepath));
			mmh.addInline(fileId, fsr);
			
			mailSender.send(mm);
			log.info("邮件已发送到：" + recipient);
		} catch (Exception e) {
			log.error("邮件发送失败", e);
		}
	}
}
