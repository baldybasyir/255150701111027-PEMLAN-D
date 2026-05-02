import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormMahasiswaSwing extends JFrame {
    private JTextField tfNama, tfTanggalLahir, tfNoPendaftaran, tfNoTelp, tfEmail;
    private JTextArea  taAlamat;

    public FormMahasiswaSwing() {
        setTitle("Form Pendaftaran Mahasiswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 320);
        setLocationRelativeTo(null);
        setResizable(false);
       // Main panel ges
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(220, 220, 230));
        main.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(220, 220, 230));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // buat Label kiri lebar tetap
        Dimension labelSize = new Dimension(130, 20);
        // Row 0: Nama Lengkap
        tfNama = new JTextField(20);
        addRow(form, gbc, 0, "Nama Lengkap", tfNama, labelSize, false);
        // Row 1: Tanggal Lahir
        tfTanggalLahir = new JTextField(20);
        addRow(form, gbc, 1, "Tanggal Lahir", tfTanggalLahir, labelSize, false);
        // Row 2: Nomor Pendaftaran
        tfNoPendaftaran = new JTextField(20);
        addRow(form, gbc, 2, "Nomor Pendaftaran", tfNoPendaftaran, labelSize, false);
        // Row 3: No. Telp
        tfNoTelp = new JTextField(20);
        addRow(form, gbc, 3, "No. Telp", tfNoTelp, labelSize, false);
        // Row 4: Alamat (textarea) alamat mas e
        taAlamat = new JTextArea(3, 20);
        taAlamat.setLineWrap(true);
        taAlamat.setWrapStyleWord(true);
        JScrollPane spAlamat = new JScrollPane(taAlamat);
        spAlamat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addRow(form, gbc, 4, "Alamat", spAlamat, labelSize, true);
        // Row 5: E-mail ( buat email masss e)
        tfEmail = new JTextField(20);
        addRow(form, gbc, 5, "E-mail", tfEmail, labelSize, false);
        // Row 6: tombol submit (rata kanan) masss e
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        JButton btnSubmit = new JButton("submit");
        btnSubmit.addActionListener(e -> onSubmit());
        form.add(btnSubmit, gbc);
        main.add(form, BorderLayout.CENTER);
        setContentPane(main);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, JComponent field, Dimension labelSize, boolean tallRow) {
        // Label
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0;
        JLabel lbl = new JLabel(labelText);
        lbl.setPreferredSize(labelSize);
        lbl.setFont(new Font("Futura", Font.PLAIN, 12));
        panel.add(lbl, gbc);
        // buat Field Mass e
        gbc.gridx = 1; gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        if (tallRow) {
            gbc.ipady = 40;
        } else {
            gbc.ipady = 0;
        }
        panel.add(field, gbc);
        gbc.ipady = 0;
    }

    private void onSubmit() {
        String nama    = tfNama.getText().trim();
        String tgl     = tfTanggalLahir.getText().trim();
        String noPend  = tfNoPendaftaran.getText().trim();
        String noTelp  = tfNoTelp.getText().trim();
        String alamat  = taAlamat.getText().trim();
        String email   = tfEmail.getText().trim();

        if (nama.isEmpty() || tgl.isEmpty() || noPend.isEmpty() ||
            noTelp.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Semua kolom harus diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        showDataWindow(nama, tgl, noPend, noTelp, alamat, email);
    }

    private void showDataWindow(String nama, String tgl, String noPend, String noTelp, String alamat, String email) {
        JDialog dlg = new JDialog(this, "Data Mahasiswa", true);
        dlg.setSize(380, 300);
        dlg.setLocationRelativeTo(this);
        dlg.setResizable(false);

        JPanel root = new JPanel(new BorderLayout(0, 0));
        root.setBackground(new Color(220, 220, 230));

        JLabel title = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        title.setFont(new Font("Futura", Font.PLAIN, 13));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 8, 0));
        root.add(title, BorderLayout.NORTH);

        String isi =
                String.format("Nama           : %s%n", nama) +
                String.format("Tanggal Lahir  : %s%n", tgl) +
                String.format("No.Pendaftaran : %s%n", noPend) +
                String.format("No.Telp        : %s%n", noTelp) +
                String.format("Alamat         : %s%n", alamat) +
                String.format("E-mail         : %s%n", email);

        JTextArea taData = new JTextArea(isi);
        taData.setEditable(false);
        taData.setFont(new Font("Monospaced", Font.PLAIN, 12));
        taData.setBackground(Color.WHITE);
        taData.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        JPanel dataWrapper = new JPanel(new BorderLayout());
        dataWrapper.setBackground(new Color(220, 220, 230));
        dataWrapper.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 14, 14, 14),
                BorderFactory.createLineBorder(new Color(150, 150, 200), 1)));
        dataWrapper.add(taData, BorderLayout.CENTER);
        // ini buat area kosong 
        JPanel spacer = new JPanel();
        spacer.setBackground(Color.LIGHT_GRAY);
        spacer.setPreferredSize(new Dimension(0, 80));
        dataWrapper.add(spacer, BorderLayout.SOUTH);
        root.add(dataWrapper, BorderLayout.CENTER);
        dlg.setContentPane(root);
        dlg.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMahasiswaSwing().setVisible(true));
    }
}
