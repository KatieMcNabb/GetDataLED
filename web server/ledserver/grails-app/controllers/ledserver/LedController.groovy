package ledserver
import com.ece.group7.challenge3.LED;
class LedController {

    def index() { }
    
    def turnon() {
        LED ledcontroller = new LED();
        ledcontroller.turnon();
        render("sent turn on command");
    }
    def turnoff() {
        LED ledcontroller = new LED();
        ledcontroller.turnoff();
        render("sent turn off command");
    }
}
