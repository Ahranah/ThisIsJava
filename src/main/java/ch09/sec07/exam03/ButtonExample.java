package ch09.sec07.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOK = new Button();

        btnOK.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("clicked OK button");
            }
        });

        btnOK.click();

        Button btnCancel = new Button();

        btnCancel.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("clicked Cancel button");
            }
        });

        btnCancel.click();
    }
}
