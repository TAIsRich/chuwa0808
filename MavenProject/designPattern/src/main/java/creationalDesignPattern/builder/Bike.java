package creationalDesignPattern.builder;

/**
 * @Author: Flora Zhong
 * @ClassName: Bike
 * @Description: 产品的角色
 * @Date: 8/16/22
 */

public class Bike {
    private String frame;
    private String seat;

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFrame() {
        return frame;
    }

    public String getSeat() {
        return seat;
    }
}
