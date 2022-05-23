package hu.progtech.bead;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public interface BigPage extends ActionListener {
    public void createFunctionButtons(String[] types);
    public void createFrame();
    public void createList(String[] types) throws SQLException;
    public void createColumnField();
    public void actionPerformed(ActionEvent e);
}
