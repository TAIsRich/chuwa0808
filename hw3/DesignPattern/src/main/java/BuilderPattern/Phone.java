package BuilderPattern;

import lombok.Data;

@Data
public class Phone {
    /**手机芯片*/
    private String chip;
    /** 后壳*/
    private String backCover;
    /**屏幕*/
    private String screen;
}