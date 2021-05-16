package hust.soict.hedspi.aims.gui;


import hust.soict.hedspi.aims.PlayerException;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFrame extends BaseFrame {
    public final float probabilityOfLuck = 0.5F;
    public float getRequiredNorms() {
        return requiredNorms;
    }
    public void setRequiredNorms(float requiredNorms) {
        this.requiredNorms = requiredNorms;
    }
    private float requiredNorms;

    private static Order mOrder;
    private static Media luckyItem;
    ArrayList<Order> listOrder = new ArrayList<>();

    JButton createButton = new BaseJButton("Create new Order");
    JButton addButton = new BaseJButton("Add item to the order");
    JButton delButton = new BaseJButton("Delete item by Id");
    JButton displayButton = new BaseJButton("Display the items of list order ");
    JButton getLuckyButton = new BaseJButton("Get lucky media");

    public HomeFrame() {
        super();
        setTitle("Order System - Nguyễn Minh Dũng 20184079");
        add(createButton);
        add(displayButton);
        add(getLuckyButton);
        add(addButton);
        add(delButton);
        configView();
    }

    private void configView() {
        createButton.setSize(300, 40);
        createButton.setLocation(150, 20);
        createButton.setFocusPainted(false);
        createButton.addActionListener(e -> {
            mOrder = Order.createOrder();
            if (mOrder != null) {
                listOrder.add(mOrder);
                JOptionPane.showMessageDialog(null, "Created Order!");
            } else {
                JOptionPane.showMessageDialog(null, "Order out of bound!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        addButton.setSize(300, 40);
        addButton.setLocation(150, 100);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> {
            if (mOrder != null) {
                GUIDialog selectDialog = new GUIDialog(null);
                selectDialog.setTitle("Select Media");
                JButton bookButton = new JButton("Book");
                bookButton.setSize(200, 40);
                bookButton.setLocation(200, 40);
                bookButton.setFocusPainted(false);
                bookButton.addActionListener(event -> {
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
                    bookDialog.okJButton.addActionListener(e1 -> {
                        bookDialog.setVisible(false);
                        selectDialog.setVisible(false);
                        float i = bookDialog.getCost();
                        if (mOrder.isFull()) {
                            JOptionPane.showMessageDialog(null, "Order is full!! can not add more", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else if (i == -1 || bookDialog.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Text box can't be empty", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else {
                            String[] outauthor = authorField.getText().split(",");
                            ArrayList<String> listAuthor = new ArrayList<>(Arrays.asList(outauthor));
                            Book book = new Book(bookDialog.getId(), bookDialog.getTitle(), bookDialog.getCategory(), i, listAuthor);
                            if (mOrder.isInitemsOrdered(book)) {
                                JOptionPane.showMessageDialog(null, "Item id duplicate, try again",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                            } else {
                                mOrder.addMedia(book);
                                JOptionPane.showMessageDialog(null, "Book added!");
                            }
                        }
                    });

                    bookDialog.setVisible(true);
                });
                selectDialog.add(bookButton);

                JButton dvdButton = new JButton("Digital Video Disc");
                dvdButton.setSize(200, 40);
                dvdButton.setLocation(200, 150);
                dvdButton.setFocusPainted(false);
                dvdButton.addActionListener(e12 -> {
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

                    dvdDialog.okJButton.addActionListener(e121 -> {
                        dvdDialog.setVisible(false);
                        selectDialog.setVisible(false);
                        float i = dvdDialog.getCost();
                        int length;
                        try {
                            length = Integer.parseInt(textField.getText());
                        } catch (Exception e2) {
                            length = -1;
                        }
                        if (mOrder.isFull()) {
                            JOptionPane.showMessageDialog(null, "Order is full!! can not add more", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else if (i == -1 || length == -1 || dvdDialog.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Text box can't be empty", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else {
                            String director = directorField.getText();
                            DigitalVideoDisc dvd = new DigitalVideoDisc(dvdDialog.getId(), dvdDialog.getTitle(), dvdDialog.getCategory(), i, length, director);
                            int result = JOptionPane.showConfirmDialog(null, "Want play DVD?", "Play",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (result == JOptionPane.YES_OPTION) {
                                String message = "Playing DVD: " + dvdDialog.getTitle() + "\n";
                                message += "DVD length: " + length;
                                JOptionPane.showMessageDialog(null, message);
                            }
                            if (mOrder.isInitemsOrdered(dvd)) {
                                JOptionPane.showConfirmDialog(null, "Item id duplicate, try again",
                                        "Warning", JOptionPane.OK_CANCEL_OPTION);
                            } else {
                                mOrder.addMedia(dvd);
                                JOptionPane.showMessageDialog(null, "DVD added!");
                            }
                        }
                    });


                    dvdDialog.setVisible(true);

                });

                selectDialog.add(dvdButton);

                JButton cdButton = new JButton("Compact Disc");
                cdButton.setSize(200, 40);
                cdButton.setLocation(200, 250);
                cdButton.setFocusPainted(false);
                cdButton.addActionListener(e13 -> {
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


                    cdDialog.okJButton.addActionListener(e131 -> {
                        cdDialog.setVisible(false);
                        selectDialog.setVisible(false);
                        float i = cdDialog.getCost();
                        if (mOrder.isFull()) {
                            JOptionPane.showMessageDialog(null, "Order is full!! can not add more", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else if (i == -1 || cdDialog.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Text box can't be empty", "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        } else {
//                            String director = directorField.getText();
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
                                JOptionPane.showMessageDialog(null, "Text box can't be empty", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            } else {
                                int result = JOptionPane.showConfirmDialog(null, "Want to play CD ?", "Play",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (result == JOptionPane.YES_OPTION) {
                                    List<Track> tracks = cd.getTracks();
                                    StringBuilder message = new StringBuilder("Playing TrackList: " + cdDialog.getTitle() + "\n");
                                    message.append("Track List length: ").append(cd.getLength()).append("\n");
                                    for (Track track : tracks) {
                                        message.append("Playing Track: ").append(track.getTitle()).append("\n");
                                        message.append("Track length: ").append(track.getLength()).append("\n");
                                    }
                                    JOptionPane.showMessageDialog(null, message.toString());
                                }
                                if (mOrder.isInitemsOrdered(cd)) {
                                    JOptionPane.showConfirmDialog(null, "Item id duplicate, try again\n",
                                            "Warning", JOptionPane.OK_CANCEL_OPTION);
                                } else {
                                    mOrder.addMedia(cd);
                                    JOptionPane.showMessageDialog(null, "CD added!");
                                }
                            }
                        }
                    });


                    cdDialog.setVisible(true);

                });
                selectDialog.add(cdButton);

                selectDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Create order first!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });


        delButton.setSize(300, 40);
        delButton.setLocation(150, 180);
        delButton.setFocusPainted(false);
        delButton.addActionListener(e -> {
            if (mOrder != null) {
                String strid = JOptionPane.showInputDialog(null,
                        "Id want to remove? ",
                        "Delete ID",
                        JOptionPane.INFORMATION_MESSAGE);
                if (mOrder.isId(strid)) {
                    mOrder.removeMedia(strid);
                    JOptionPane.showMessageDialog(null, "Removed Media ID = " + strid);
                } else {
                    JOptionPane.showMessageDialog(null, "Media not exist, ID = " + strid, "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Create order first", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });


        displayButton.setSize(300, 40);
        displayButton.setLocation(150, 260);
        displayButton.setFocusPainted(false);
        displayButton.addActionListener(e -> {
            if (mOrder != null) {
                if (mOrder.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Order empty");
                } else {
                    Media luckyItemShow = null;
                    if (mOrder.getitemsOrdered().contains(luckyItem)) {
                        luckyItemShow = luckyItem;
                    }
                    GUIDialog disDialog = new GUIDialog(null);
                    disDialog.setTitle("List items of Order");
                    String[] column_names = {"ID", "Type", "Title", "Category", "Cost($)"};
                    List<Media> items = mOrder.getitemsOrdered();
                    DefaultTableModel model = new DefaultTableModel(null, column_names);
                    JTable table = new JTable(model);
                    for (Media media : items) {
                        String typeString;
                        if (media instanceof Book)
                            typeString = "Book";
                        else if (media instanceof DigitalVideoDisc) {
                            typeString = "DVD";
                        } else {
                            typeString = "CD";
                        }
                        float cost = media.getCost();
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), cost});
                    }
                    float totalCostDisplay = mOrder.totalCost();
                    if (luckyItemShow != null) {
                        totalCostDisplay = mOrder.totalCost() - luckyItemShow.getCost();
                    }
                    model.addRow(new Object[]{"", "", "", "Total: ", totalCostDisplay});
                    model.addRow(new Object[]{"", "", "", "",});

                    table.setSize(500, 300);
                    table.setLocation(50, 30);
                    disDialog.setLayout(new BorderLayout());
                    disDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
                    disDialog.add(table, BorderLayout.CENTER);
                    TableColumn column;
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
                JOptionPane.showMessageDialog(null, "Create order first", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });


        getLuckyButton.setSize(300, 40);
        getLuckyButton.setLocation(150, 340);
        getLuckyButton.setFocusPainted(false);
        getLuckyButton.addActionListener(e -> {
            if (mOrder != null && listOrder.size() > 1) {
                float valueRequired = Float.parseFloat(JOptionPane.showInputDialog(null,
                        "Nhập giá tiền bạn muốn set:", "Lucky Item ^ _^ ",
                        JOptionPane.INFORMATION_MESSAGE));
                setRequiredNorms(valueRequired);
                ArrayList<Integer> listOrderSatisfied = orderListTotalHigherPrefined();
                float luckRate = (float) (Math.random());
                int sizeOfList = listOrderSatisfied.size();
                int getLuckyNumber = (int) (luckRate * sizeOfList);
                if (luckRate < probabilityOfLuck || sizeOfList == 0) {
                    JOptionPane.showConfirmDialog(null, "Good luck later!!",
                            "Warning", JOptionPane.OK_CANCEL_OPTION);
                } else {
                    float costOfItemGive;
                    Order orderLuckyReceiveItem = listOrder.get(listOrderSatisfied.get(getLuckyNumber));
                    float totalCostOfLuckyOrDer = orderLuckyReceiveItem.totalCost();
                    System.out.printf("totalCostOfLuckyOrDer: %f\n", totalCostOfLuckyOrDer);
                    if (totalCostOfLuckyOrDer > valueRequired) {
                        costOfItemGive = valueRequired;
                    } else {
                        float testPercento = ((float) 2 / (float) 10);
                        System.out.println(testPercento);
                        costOfItemGive = totalCostOfLuckyOrDer * testPercento;
                    }
                    if (orderLuckyReceiveItem.getitemsOrdered().contains(luckyItem)) {
                        costOfItemGive = costOfItemGive - luckyItem.getCost();
                    }
                    System.out.printf("costOfItemGive: %f\n", costOfItemGive);
                    luckyItem = new Media("0", "Gift", "Gift", costOfItemGive);
                    try {
                        luckyItem.play();
                    } catch (PlayerException playerException) {
                        playerException.printStackTrace();
                    }
                    orderLuckyReceiveItem.addMedia(luckyItem);
                    mOrder = orderLuckyReceiveItem;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Create order first", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public ArrayList<Integer> orderListTotalHigherPrefined() {
        ArrayList<Integer> arrayResult = new ArrayList<>();
        float costRequired = this.getRequiredNorms();
        for (int i = 0; i < listOrder.size(); i++) {
            if (listOrder.get(i).totalCost() > costRequired && listOrder.get(i).totalCost() > 0) {
                arrayResult.add(i);
            }
        }
        return arrayResult;
    }
}
