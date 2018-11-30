package boxordering;

import java.awt.Dialog.ModalityType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }

    private ArrayList<Box> boxes = new ArrayList<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addbox = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ordersLabel = new javax.swing.JLabel();
        totalCostLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addbox.setText("Add Box");
        addbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addboxActionPerformed(evt);
            }
        });

        jLabel1.setText("Flex Box Ordering System");

        jButton1.setText("Clear Box");

        ordersLabel.setText("Orders Made: 0");

        totalCostLabel.setText("Total Cost: £0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(addbox)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ordersLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(totalCostLabel)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(addbox)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addComponent(ordersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCostLabel)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel() {
        setVisible(true);
        JOptionPane.showMessageDialog(null,
                "The 'Add box' operation has been cancelled.",
                "Cancellation",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void update() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Box box : boxes) {
            totalPrice = totalPrice.add(box.calculatePrice());
        }
        totalCostLabel.setText("Total Price: £" + totalPrice.setScale(2,RoundingMode.HALF_UP).toString());
    }

    private void addboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addboxActionPerformed

        // declare all the box attributes used for Box initialisation.
        Box box; // may be initialised as a subclass of Box.
        int cardboardGrade;
        double width, length, height;
        boolean sealable;
        int colourType;
        Object reinforcedCorners;
        int quantity;

        // hide MainMenu form to avoid user confusion
        setVisible(false);

        BasicInfoForm infoForm = new BasicInfoForm();
        infoForm.setVisible(true);
        if (!infoForm.isValid()) {
            cancel();
            return;
        }
        BasicInfoFormResult infoResult = (BasicInfoFormResult) infoForm.getInfo();
        cardboardGrade = infoResult.grade;
        width = infoResult.width;
        height = infoResult.height;
        length = infoResult.length;
        sealable = infoResult.sealable;

        // with a cardboardGrade of 1, the user cannot have any colour.
        if (cardboardGrade == 1) {
            JOptionPane.showMessageDialog(null, "You will have no colours.", "Information", JOptionPane.INFORMATION_MESSAGE);
            colourType = 0;

            // with a cardboardGrade of 5, the user must have two colours.
        } else if (cardboardGrade == 5) {
            JOptionPane.showMessageDialog(null, "You will have two colours.", "Information", JOptionPane.INFORMATION_MESSAGE);
            colourType = 2;

            // any other cardboardGrade, the user can choose what colour they want.
        } else {

            ColourForm colourForm = new ColourForm();
            if (cardboardGrade == 4) {
                colourForm.removeNoColourOption();
            }
            colourForm.setVisible(true);
            if (!colourForm.isValid()) {
                cancel();
                return;
            }
            colourType = (int) colourForm.getInfo();
        }

        // if the colourType is not 0, then the box is a coloured box, and might be reinforced.
        if (colourType != 0) {
            if (colourType == 1) {

                //type II box.
                box = new ColourBox(width, length, height, cardboardGrade, sealable, colourType);

            } else {
                ReinforcedForm reinforcedForm = new ReinforcedForm();
                reinforcedForm.setVisible(true);
                if (!reinforcedForm.isValid()) {
                    cancel();
                    return;
                }
                reinforcedCorners = (Object) reinforcedForm.getInfo();
                System.out.println(reinforcedCorners);
                if (reinforcedCorners == null) {

                    // type III box.
                    box = new ColourBox(width, length, height, cardboardGrade, sealable, colourType);

                } else {

                    // type IV or V box.
                    box = new ReinforcedBox(width, length, height, cardboardGrade, sealable, colourType, (boolean) reinforcedCorners);

                }
            }
        } else {

            // type I box.
            box = new BasicBox(width, length, height, cardboardGrade, sealable);
        }

        // get the amount of these boxes and the clone them, adding the copies to the ArrayList.
        QuantityForm quantityForm = new QuantityForm();
        quantityForm.setVisible(true);
        if (!quantityForm.isValid()) {
            cancel();
            return;
        }
        quantity = (int) quantityForm.getInfo();

        for (int i = 0; i < quantity; i++) {
            try {
                boxes.add((Box) box.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Fatal: box clone failed.");
            }
        }

        // show main form, updated with the box order they just placed.
        setVisible(true);
        /*        orderPrice = box.calculatePrice();
        totalPrice = totalPrice.add(orderPrice);
        totalCostLabel.setText("Total Price: £" + totalPrice.toString()); */
        update();


    }//GEN-LAST:event_addboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel ordersLabel;
    private javax.swing.JLabel totalCostLabel;
    // End of variables declaration//GEN-END:variables
}
