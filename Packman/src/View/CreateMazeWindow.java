package View;

import ViewModel.MyViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;


public class CreateMazeWindow implements Observer {

    public TextField new_maze_rows;
    public TextField new_maze_columns;
    private MyViewModel myViewModel;

    public void generateMaze(ActionEvent actionEvent) {
        try {
            int rows = Integer.valueOf(new_maze_rows.getText());
            int cols = Integer.valueOf(new_maze_columns.getText());

            myViewModel.generateMaze(rows,cols);

        }
        catch (NumberFormatException | UnknownHostException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Enter Numbers Only");
            alert.show();
        }
        catch (IllegalArgumentException invalidargs){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Enter Numbers bigger than 2");
            alert.show();
        }
    }

    public void setViewModel(MyViewModel viewModel) {
        myViewModel = viewModel;
        //myViewModel.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}