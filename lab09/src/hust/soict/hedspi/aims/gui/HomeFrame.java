package hust.soict.hedspi.aims.gui;


import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HomeFrame extends GUIFrame {
    JButton createButton = new JButton("Create new Order");
    ;
    JButton addButton = new JButton("Add item to the order");
    JButton delButton = new JButton("Delete item by Id");
    JButton displayButton = new JButton("Display the items of list order ");

    private static Order anOrder;

    public HomeFrame() {
        super();
//		addExitButton();
        setTitle("Order System");
        createButton.setSize(300, 40);
        createButton.setLocation(150, 20);
        createButton.setFocusPainted(false);
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                anOrder = Order.createOrder();
                if (anOrder != null)
                    JOptionPane.showMessageDialog(null, "Create new Order thanh cong");
                else {
                    JOptionPane.showMessageDialog(null, "Ban da create qua so luong cho phep", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(createButton);

        addButton.setSize(300, 40);
        addButton.setLocation(150, 100);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (anOrder != null) {
                    GUIDialog selectDialog = new GUIDialog(null);
                    selectDialog.setTitle("Select Media");
                    JButton bookButton = new JButton("Book");
                    bookButton.setSize(200, 40);
                    bookButton.setLocation(200, 40);
                    bookButton.setFocusPainted(false);
                    bookButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            GUIDialog bookDialog = new GUIDialog(null, "Book");
                            JTextField authorField = new JTextField();
                            JLabel authorJLabel = new JLabel("Author");
                            authorJLabel.setSize(200, 40);
                            authorJLabel.setLocation(100, 180);
                            bookDialog.add(authorJLabel);

                            authorField.setSize(200, 30);
                            authorField.setLocation(300, 180);
                            bookDialog.add(authorField);

                            JLabel noteJLabel = new JLabel("* Cac author cach nhau boi dau phay ' , '");
                            noteJLabel.setSize(300, 40);
                            noteJLabel.setLocation(100, 220);
                            bookDialog.add(noteJLabel);
                            bookDialog.okJButton.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    bookDialog.setVisible(false);
                                    selectDialog.setVisible(false);
                                    float i = bookDialog.getCost();
                                    if (anOrder.isFull()) {
                                        JOptionPane.showMessageDialog(null, "Order dax day\nKhong the them vao Order", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else if (i == -1 || bookDialog.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Khong the them vao Order\nBan nhap sai dinh dang\nCac truong ID, Title, Category, Code khong the trong", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        String[] outauthor = authorField.getText().split(",");
                                        ArrayList<String> listauthor = new ArrayList<String>();
                                        for (String test : outauthor) {
                                            listauthor.add(test);
                                        }
                                        Book book = new Book(bookDialog.getId(), bookDialog.getTitle(), bookDialog.getCategory(), i, listauthor);
                                        if (anOrder.isInitemsOrdered(book)) {
                                            JOptionPane.showMessageDialog(null, "Da ton tai san pham trong Order\nKhong the them vao Order",
                                                    "Warning", JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            anOrder.addMedia(book);
                                            JOptionPane.showMessageDialog(null, "Them Book thanh cong");
                                        }
                                    }
                                }
                            });

                            bookDialog.setVisible(true);
                        }
                    });
                    selectDialog.add(bookButton);

                    JButton dvdButton = new JButton("Digital Video Disc");
                    dvdButton.setSize(200, 40);
                    dvdButton.setLocation(200, 150);
                    dvdButton.setFocusPainted(false);
                    dvdButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            GUIDialog dvdDialog = new GUIDialog(null, "Digital Video Disc");
                            JTextField textField = new JTextField();
                            JLabel textJLabel = new JLabel("Length");
                            textJLabel.setSize(200, 40);
                            textJLabel.setLocation(100, 180);
                            dvdDialog.add(textJLabel);
                            textField.setSize(200, 30);
                            textField.setLocation(300, 180);
                            dvdDialog.add(textField);

                            JTextField directorField = new JTextField();
                            JLabel directorJLabel = new JLabel("Director");
                            directorJLabel.setSize(200, 40);
                            directorJLabel.setLocation(100, 220);
                            dvdDialog.add(directorJLabel);

                            directorField.setSize(200, 30);
                            directorField.setLocation(300, 220);
                            dvdDialog.add(directorField);

                            dvdDialog.okJButton.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    dvdDialog.setVisible(false);
                                    selectDialog.setVisible(false);
                                    float i = dvdDialog.getCost();
                                    int length;
                                    try {
                                        length = Integer.parseInt(textField.getText());
                                    } catch (Exception e2) {
                                        length = -1;
                                    }
                                    if (anOrder.isFull()) {
                                        JOptionPane.showMessageDialog(null, "Order dax day\nKhong the them vao Order", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else if (i == -1 || length == -1 || dvdDialog.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Khong the them vao Order\nBan nhap sai dinh dang\nCac truong ID, Title, Category, Code, Length khong the trong", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        String director = directorField.getText();
                                        DigitalVideoDisc dvd = new DigitalVideoDisc(dvdDialog.getId(), dvdDialog.getTitle(), dvdDialog.getCategory(), i, length, director);
                                        int result = JOptionPane.showConfirmDialog(null, "Ban co muon phat DVD ?", "Play",
                                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                        if (result == JOptionPane.YES_OPTION) {
                                            String message = "Playing DVD: " + dvdDialog.getTitle() + "\n";
                                            message += "DVD length: " + length;
                                            JOptionPane.showMessageDialog(null, message);
                                        }
                                        if (anOrder.isInitemsOrdered(dvd)) {
                                            JOptionPane.showConfirmDialog(null, "Da ton tai san pham trong Order\nKhong the them vao Order",
                                                    "Warning", JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            anOrder.addMedia(dvd);
                                            JOptionPane.showMessageDialog(null, "Them DVD thanh cong");
                                        }
                                    }
                                }
                            });


                            dvdDialog.setVisible(true);

                        }
                    });

                    selectDialog.add(dvdButton);

                    JButton cdButton = new JButton("Compact Disc");
                    cdButton.setSize(200, 40);
                    cdButton.setLocation(200, 250);
                    cdButton.setFocusPainted(false);
                    cdButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            GUIDialog cdDialog = new GUIDialog(null, "Compact Disc");

                            JTextField textField = new JTextField();
                            JLabel textJLabel = new JLabel("Artist");
                            textJLabel.setSize(200, 40);
                            textJLabel.setLocation(100, 180);
                            cdDialog.add(textJLabel);
                            textField.setSize(200, 30);
                            textField.setLocation(300, 180);
                            cdDialog.add(textField);

                            JTextField directorField = new JTextField();
                            JLabel directorJLabel = new JLabel("Director");
                            directorJLabel.setSize(200, 40);
                            directorJLabel.setLocation(100, 220);
                            cdDialog.add(directorJLabel);
                            directorField.setSize(200, 30);
                            directorField.setLocation(300, 220);
                            cdDialog.add(directorField);

                            JTextField trackField = new JTextField();
                            JLabel trackJLabel = new JLabel("Track");
                            trackJLabel.setSize(200, 40);
                            trackJLabel.setLocation(100, 260);
                            cdDialog.add(trackJLabel);
                            trackField.setSize(200, 30);
                            trackField.setLocation(300, 260);
                            cdDialog.add(trackField);

                            JLabel noteJLabel = new JLabel("* Track: <Track1>:<Length1>,<Track2>:<Lenght2>,...");
                            noteJLabel.setSize(500, 40);
                            noteJLabel.setLocation(100, 300);
                            cdDialog.add(noteJLabel);


                            cdDialog.okJButton.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    cdDialog.setVisible(false);
                                    selectDialog.setVisible(false);
                                    float i = cdDialog.getCost();
                                    if (anOrder.isFull()) {
                                        JOptionPane.showMessageDialog(null, "Order dax day\nKhong the them vao Order", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else if (i == -1 || cdDialog.isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Khong the them vao Order\nBan nhap sai dinh dang\nCac truong ID, Title, Category, Code, Tracks khong the trong", "Warning",
                                                JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        String director = directorField.getText();
                                        CompactDisc cd = new CompactDisc(cdDialog.getId(), cdDialog.getTitle(), cdDialog.getCategory(), i, directorField.getText(), textField.getText());
                                        String[] outString = trackField.getText().split(",+");
                                        for (String out : outString) {
                                            String[] a = out.split(":+");
                                            Track track;
                                            try {
                                                track = new Track(a[0], Integer.parseInt(a[1]));
                                            } catch (Exception e2) {
                                                continue;
                                            }
                                            cd.addTrack(track);
                                        }
                                        if (cd.numberTracks() == 0) {
                                            JOptionPane.showMessageDialog(null, "Khong the them vao Order\nBan nhap sai dinh dang\nCac truong ID, Title, Category, Code, Tracks khong the trong", "Warning",
                                                    JOptionPane.WARNING_MESSAGE);
                                        } else {
                                            int result = JOptionPane.showConfirmDialog(null, "Ban co muon phat CD ?", "Play",
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                            if (result == JOptionPane.YES_OPTION) {
                                                List<Track> tracks = cd.getTracks();
                                                String message = "Playing TrackList: " + cdDialog.getTitle() + "\n";
                                                message += "Tracklist length: " + cd.getLength() + "\n";
                                                for (Track track : tracks) {
                                                    message += "Playing Track: " + track.getTitle() + "\n";
                                                    message += "Track length: " + track.getLength() + "\n";
                                                }
                                                JOptionPane.showMessageDialog(null, message);
                                            }
                                            if (anOrder.isInitemsOrdered(cd)) {
                                                JOptionPane.showConfirmDialog(null, "Da ton tai san pham trong Order\nKhong the them vao Order",
                                                        "Warning", JOptionPane.WARNING_MESSAGE);
                                            } else {
                                                anOrder.addMedia(cd);
                                                JOptionPane.showMessageDialog(null, "Them CD thanh cong");
                                            }
                                        }
                                    }
                                }
                            });


                            cdDialog.setVisible(true);

                        }
                    });
                    selectDialog.add(cdButton);

                    selectDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua create Order", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(addButton);

        delButton.setSize(300, 40);
        delButton.setLocation(150, 180);
        delButton.setFocusPainted(false);
        delButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (anOrder != null) {
                    String strid = JOptionPane.showInputDialog(null,
                            "Moi ban nhap ID muon xoa: ",
                            "Delete ID",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (anOrder.isId(strid)) {
                        anOrder.removeMedia(strid);
                        JOptionPane.showMessageDialog(null, "Xoa thanh cong Media co ID = " + strid);
                    } else {
                        JOptionPane.showMessageDialog(null, "Khong ton tai Media co ID = " + strid, "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua create Order", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        add(delButton);

        displayButton.setSize(300, 40);
        displayButton.setLocation(150, 260);
        displayButton.setFocusPainted(false);
        displayButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (anOrder != null) {
                    if (anOrder.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Order empty");
                    } else {
                        Media luckyMedia = anOrder.getALuckyItem();

                        GUIDialog disDialog = new GUIDialog(null);
                        disDialog.setTitle("List items of Order");
                        String column_names[] = {"ID", "Type", "Title", "Category", "Cost($)"};
                        List<Media> items = new ArrayList<Media>();
                        items = anOrder.getitemsOrdered();
                        DefaultTableModel model = new DefaultTableModel(null, column_names);
                        JTable table = new JTable(model);
//						model.addRow(new Object[] {new String("ID"),new String("Type"),
//								new String("Title"),new String("Category"),new String("Cost($)")});
                        for (Media media : items) {
                            String typeString;
                            if (media instanceof Book)
                                typeString = "Book";
                            else if (media instanceof DigitalVideoDisc) {
                                typeString = "DVD";
                            } else {
                                typeString = "CD";
                            }
                            float cost = media.equals(luckyMedia) ? 0 : media.getCost();
                            model.addRow(new Object[]{media.getId(), typeString,
                                    media.getTitle(), media.getCategory(), cost});
                        }

                        model.addRow(new Object[]{"", "", "", "Total: ", anOrder.totalCost() - luckyMedia.getCost()});
//						model.addRow(new Object[] {"","","","",});

                        table.setSize(500, 300);
                        table.setLocation(50, 30);
                        disDialog.setLayout(new BorderLayout());
                        disDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
                        disDialog.add(table, BorderLayout.CENTER);
                        TableColumn column = null;
                        for (int i = 0; i < 5; i++) {
                            column = table.getColumnModel().getColumn(i);
                            if (i == 0) {
                                column.setPreferredWidth(50);
                            }
                            if (i == 1) {
                                column.setPreferredWidth(50);
                            }
                            if (i == 2) {
                                column.setPreferredWidth(200);
                            }
                            if (i == 3) {
                                column.setPreferredWidth(150);
                            }
                            if (i == 4) {
                                column.setPreferredWidth(50);
                            }

                        }
                        disDialog.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua create Order", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        add(displayButton);

        setVisible(true);
    }
}
