package view;

import models.Book;
import controllers.BookController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Window extends JFrame implements BookView {

    private final JTextField tfAuthor = new JTextField(20);
    private final JTextField tfTitle = new JTextField(20);
    private final JTextField tfYear = new JTextField(20);
    private final JTextField tfAdditional = new JTextField(20);

    private final JTextArea booksArea = new JTextArea(12, 50);

    public final BookController controller;

    public Window(BookController controller) {
        this.controller = controller;

        setTitle("Книги");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setMinimumSize(new Dimension(500, 400));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JPanel formPanel = new JPanel();

        JLabel lblAuthor = new JLabel("Автор:");
        JLabel lblTitle = new JLabel("Название:");
        JLabel lblYear = new JLabel("Год:");
        JLabel lblAdditional = new JLabel("Дополнительно:");

        JButton btnAdd = new JButton("Добавить");

        btnAdd.addActionListener(e -> controller.addBookClicked());

        GroupLayout layout = new GroupLayout(formPanel);
        formPanel.setLayout(layout);

        JScrollPane scrollPane = new JScrollPane(booksArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Список книг")
        );

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setContentPane(mainPanel);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(
                                                GroupLayout.Alignment.TRAILING
                                        )
                                        .addComponent(lblAuthor)
                                        .addComponent(lblTitle)
                                        .addComponent(lblYear)
                                        .addComponent(lblAdditional)
                        )

                        .addGroup(
                                layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING
                                        )
                                        .addComponent(tfAuthor)
                                        .addComponent(tfTitle)
                                        .addComponent(tfYear)
                                        .addComponent(tfAdditional)
                        )

                        .addComponent(btnAdd)
        );


        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE
                                                )
                                                .addComponent(lblAuthor)
                                                .addComponent(tfAuthor)
                                )

                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE
                                                )
                                                .addComponent(lblTitle)
                                                .addComponent(tfTitle)
                                )

                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE
                                                )
                                                .addComponent(lblYear)
                                                .addComponent(tfYear)
                                )

                                .addGroup(
                                        layout.createParallelGroup(
                                                        GroupLayout.Alignment.BASELINE
                                                )
                                                .addComponent(lblAdditional)
                                                .addComponent(tfAdditional)
                                )

                        )
                                .addComponent(btnAdd)


        );

        booksArea.setEditable(false);
        booksArea.setLineWrap(true);
        booksArea.setWrapStyleWord(true);



        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public String getAuthor() {
        return tfAuthor.getText();
    }

    @Override
    public String getTitle() {
        return tfTitle.getText();
    }

    @Override
    public String getYear() {
        return tfYear.getText();
    }

    @Override
    public String getAdditionalInfo() {
        return tfAdditional.getText();
    }

    @Override
    public void clearInput() {
        tfAuthor.setText("");
        tfTitle.setText("");
        tfYear.setText("");
        tfAdditional.setText("");
    }

    @Override
    public void showBooks(List<Book> books) {
        booksArea.setText("");

        int i = 1;

        for (Book book : books) {
            booksArea.append(
                    i++ + ". "
                            + book.year() + "г. "
                            + book.author() + ": "
                            + book.title()
                            + "\n"
                            + book.additionalInfo()
                            + System.lineSeparator()
            );
        }
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Ошибка",
                JOptionPane.ERROR_MESSAGE
        );
    }
}