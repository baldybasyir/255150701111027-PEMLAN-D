import java.awt.*;
import java.awt.event.*;
public class MainFrame extends Frame {
    private TextField utsField, uasField, tugasField, kuisField, fieldHasil;
    private Checkbox pemlanCheckbox, asdCheckbox, matkomlanCheckbox, probstatCheckbox;
    private CheckboxGroup grupMatkul;
    private Button hitungButton, tampilButton;
    private TextArea areaOutput;

    public MainFrame() {
        initComponents();
        setupEventHandlers();
    }

    private void initComponents() {
        setTitle("Hitung Nilai Akhir dengan GUI");
        setSize(500, 750);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        Label title = new Label("Hitung Nilai Akhir", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        // Panel pilihan mata kuliah
        Panel buttonRadio = new Panel(new FlowLayout(FlowLayout.CENTER));
        grupMatkul = new CheckboxGroup();
        buttonRadio.add(asdCheckbox = new Checkbox("ASD", grupMatkul, false));
        buttonRadio.add(pemlanCheckbox = new Checkbox("Pemlan", grupMatkul, true));
        buttonRadio.add(matkomlanCheckbox = new Checkbox("Matkomlan", grupMatkul, false));
        buttonRadio.add(probstatCheckbox = new Checkbox("Probstat", grupMatkul, false));
        gbc.gridy = 1; gbc.gridwidth = 2;
        add(buttonRadio, gbc);

        // Panel input nilai
        Panel panelInput = new Panel(new GridLayout(5, 2, 10, 10));
        panelInput.add(new Label("Tugas :", Label.RIGHT));
        tugasField = new TextField(8);
        panelInput.add(tugasField);
        
        panelInput.add(new Label("Kuis :", Label.RIGHT));
        kuisField = new TextField(8);
        panelInput.add(kuisField);
        
        panelInput.add(new Label("UTS :", Label.RIGHT));
        utsField = new TextField(8);
        panelInput.add(utsField);
        
        panelInput.add(new Label("UAS :", Label.RIGHT));
        uasField = new TextField(8);
        panelInput.add(uasField);
        
        panelInput.add(new Label("Hasil :", Label.RIGHT));
        fieldHasil = new TextField(8);
        fieldHasil.setEditable(false);
        panelInput.add(fieldHasil);
        
        gbc.gridy = 2; gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 60, 10, 60);
        add(panelInput, gbc);

        // Tombol Hitung
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 120, 10, 120);
        add(hitungButton = new Button("Hitung"), gbc);

        // TextArea output
        areaOutput = new TextArea("HASIL NILAI SEMUA MATA KULIAH\n\n", 12, 50, 
                                TextArea.SCROLLBARS_VERTICAL_ONLY);
        areaOutput.setEditable(false);
        gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 30, 10, 30);
        add(areaOutput, gbc);

        // Tombol Tampilkan
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 30, 20, 30);
        add(tampilButton = new Button("Tampilkan nilai semua matkul"), gbc);
    }

    private void setupEventHandlers() {
        hitungButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hitungNilai();
            }
        });

        tampilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tampilkanHasil();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void hitungNilai() {
        try {
            String tugasText = tugasField.getText().trim();
            String kuisText = kuisField.getText().trim();
            String utsText = utsField.getText().trim();
            String uasText = uasField.getText().trim();

            if (tugasText.isEmpty() || kuisText.isEmpty() || utsText.isEmpty() || uasText.isEmpty()) {
                fieldHasil.setText("Isi semua field!");
                return;
            }

            int tgs = Integer.parseInt(tugasText);
            int kuis = Integer.parseInt(kuisText);
            int uts = Integer.parseInt(utsText);
            int uas = Integer.parseInt(uasText);

            // Validasi nilai 0-100
            if (tgs < 0 || tgs > 100 || kuis < 0 || kuis > 100 || 
                uts < 0 || uts > 100 || uas < 0 || uas > 100) {
                fieldHasil.setText("Nilai harus 0-100!");
                return;
            }

            Checkbox opsi = grupMatkul.getSelectedCheckbox();
            MataKuliah matkul;
            
            if (opsi == pemlanCheckbox) {
                matkul = new Pemlan();
            } else if (opsi == asdCheckbox) {
                matkul = new ASD();
            } else if (opsi == matkomlanCheckbox) {
                matkul = new Matkomlan();
            } else {
                matkul = new Probstat();
            }
            matkul.setNilai(uts, uas, tgs, kuis);
            double hasil = matkul.hitungNilaiAkhir();
            fieldHasil.setText(String.format("%.1f", hasil));

        } catch (NumberFormatException ex) {
            fieldHasil.setText("Input harus angka!");
        }
    }

    private void tampilkanHasil() {
        String nilaiAkhir = fieldHasil.getText().trim();
        if (!nilaiAkhir.isEmpty() && !nilaiAkhir.equals("Input harus angka!") && 
            !nilaiAkhir.equals("Isi semua field!") && !nilaiAkhir.equals("Nilai harus 0-100!")) {
            
            Checkbox selected = grupMatkul.getSelectedCheckbox();
            if (selected != null) {
                String namaMatkul = selected.getLabel();
                areaOutput.append(namaMatkul + " : " + nilaiAkhir + "\n");
            }
        }
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}