package BuilderPattern;

public class HuaweiBuilder extends Builder{

    @Override
    public void buildchip() {   phone.setChip("华为自言芯片麒麟9000");  }

    @Override
    public void buildbackCover() {     phone.setBackCover("玻璃后壳");  }

    @Override
    public void buildscreen() {     phone.setScreen("国产屏幕"); }

    @Override
    public Phone getPhone() {   return phone; }
}