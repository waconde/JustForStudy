package site.waconde.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * FastDFS的文件基础信息：
 * name 文件名
 * content 文件内容
 * ext 类型
 * md5 md5码值
 * author 作者名
 *
 * @author side.wang
 */
public class FastDFSFile implements Serializable {
    private static final long serialVersionUID = - 5029376811575622173L;
    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

    public FastDFSFile(String name, byte[] content, String ext) {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "FastDFSFile [name=" + name + ", content=" + Arrays.toString(content) + ", ext=" + ext + ", md5=" + md5
                + ", author=" + author + "]";
    }
}
