package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

public class Chart_Custom extends javax.swing.JPanel {

    private Map<String, Chart_Item> map;
    private List<Chart_Item> list;
    double maxValues;

    public Chart_Custom() {
        initComponents();
        init();
    }

    private void sort() {
        List<Map.Entry<String, Chart_Item>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Chart_Item>>() {
            @Override
            public int compare(Map.Entry<String, Chart_Item> o1, Map.Entry<String, Chart_Item> o2) {
                return o1.getValue().getValues() > o2.getValue().getValues() ? -1 : o1.getValue().getValues() == o2.getValue().getValues() ? 0 : -1;
            }
        });
        list.clear();
        maxValues = 0;
        for (Map.Entry<String, Chart_Item> item : entryList) {
            list.add(item.getValue());
            if (item.getValue().getValues() > maxValues) {
                maxValues = item.getValue().getValues();
            }
        }
    }

    private void init() {
        map = new HashMap<>();
        list = new ArrayList<>();
        //  Test data
        map.put("java", new Chart_Item("Java", 1000, new Color(44, 198, 138), new ImageIcon(getClass().getResource("/icon/java.png"))));
        map.put("cpp", new Chart_Item("C++", 5000, new Color(44, 96, 198), new ImageIcon(getClass().getResource("/icon/cpp.png"))));
        map.put("flutter", new Chart_Item("Flutter", 1300, new Color(107, 44, 198), new ImageIcon(getClass().getResource("/icon/flutter.png"))));
        map.put("c_sharp", new Chart_Item("C Sharp", 200, new Color(205, 61, 198), new ImageIcon(getClass().getResource("/icon/c_sharp.png"))));
        map.put("python", new Chart_Item("Python", 350, new Color(205, 198, 61), new ImageIcon(getClass().getResource("/icon/python.png"))));
        map.put("ruby", new Chart_Item("Ruby", 350, new Color(234, 76, 83), new ImageIcon(getClass().getResource("/icon/ruby.png"))));
        map.put("kotlin", new Chart_Item("Kotlin", 2000, new Color(205, 142, 61), new ImageIcon(getClass().getResource("/icon/kotlin.png"))));
        sort();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); //  for image smooth
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);    //  for text smooth
        g2.setFont(new Font("sansserif", 1, 17));
        int size = map.size();
        int space = 5;
        int itemHeight = ((getHeight() - ((space * size) + 1)) / size);
        int y = space;
        int maxWidth = getWidth() - 300;    //  300 space right
        for (Chart_Item item : map.values()) {
            g2.setColor(item.getColor());
            double width = item.getValues() * maxWidth / maxValues;
            g2.fillRect(5, y, (int) width, itemHeight);
            paintIcon(g2, item, (int) width + 10, y, itemHeight);
            y += itemHeight + space;
        }
    }

    private void paintIcon(Graphics2D g2, Chart_Item item, int x, int y, int size) {
        //  size for space icon
        DecimalFormat df = new DecimalFormat("#,##0.##");
        g2.setColor(new Color(88, 88, 88));
        g2.drawImage(((ImageIcon) item.getIcon()).getImage(), x, y, size, size, null);
        g2.drawString(df.format(item.getValues()), x + size + 5, y + (size / 2 + 7));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
