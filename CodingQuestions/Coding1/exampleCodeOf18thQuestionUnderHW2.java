public class exampleCodeOf18thQuestionUnderHW2 {
        public static void main(String[] args) {
            int a = 0;
            int b = 3;
            String s = null;
            try {
                // System.out.println(b / a);
                // System.out.println(s.equals("aa"));
                throw new RuntimeException();
            } catch (ArithmeticException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (RuntimeException e) {
                e.getMessage();
    }
            System.out.println("End ...");
        } 
    
}
