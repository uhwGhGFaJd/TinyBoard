package onion.tinyboard.utils;

import org.springframework.stereotype.Component;

@Component
public class AlertUtil {

    public String makeAlert(String type, String message) {
        String outPut = null;
        switch (type) {
            case "primary":
                outPut = "<div class='alert alert-primary mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;
            case "secondary":
                outPut = "<div class='alert alert-secondary mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;
            case "success":
                outPut = "<div class='alert alert-success mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;
            case "danger":
                outPut = "<div class='alert alert-danger mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;
            case "info":
                outPut = "<div class='alert alert-info mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;
            case "light":
                outPut = "<div class='alert alert-light mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;
            case "dark":
                outPut = "<div class='alert alert-dark mt-2' role = 'alert'>";
                outPut += message;
                outPut += "</div>";
                break;

        }
        return outPut;
    }
}
