// Jam Digital //

// Formatif 2 ALPRO //
import javax.swing.*; //  membangun antarmuka pengguna grafis GUI 
import java.awt.*;   // kelas-kelas dasar untuk membangun aplikasi GUI
import java.awt.event.ActionEvent; // digunakan untuk menangani saat pengguna berinteraksi dengan komponen-komponen GUI 
import java.awt.event.ActionListener; // antarmuka yang digunakan untuk menangani event 
import java.text.SimpleDateFormat; // Kelas ini digunakan untuk memformat dan mengurai tanggal ke dalam teks
import java.util.Date; // Kelas untuk merepresentasikan tanggal dan waktu saat ini

// Kelas Induk
class DigitalClock extends JFrame {
    // Deklarasi variabel
    protected JLabel labelJam;

    public DigitalClock() {
     // Inisialisasi JLabel untuk menampilkan waktu
        labelJam = new JLabel();
        setTitle("Jam Digital");  // Menetapkan judul jendela
        setSize(300, 200);  // Menetapkan ukuran (lebar x tinggi)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Menetapkan operasi penutupan jendela
        setLocationRelativeTo(null);  // lokasi jendela ke tengah layar
        add(labelJam);  // Menambahkan labelJam ke dalam jendela
    }

    protected void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //kelas untuk memformat tanggal dan waktu      // jam:menit: detik
        labelJam.setText(sdf.format(new Date())); // string yang berisi waktu saat ini dalam format "HH:mm
    }
}

// Kelas Anak (inheritance dan overriding)
public class JamDigital extends DigitalClock {
    private Timer timerJam;

    public JamDigital() {
        setTitle("Jam Digital");

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(labelJam); // Inherited label

        add(panel);

        timerJam = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClock(); // Inherited method
            }
        });
        timerJam.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JamDigital().setVisible(true);
            }
        });
    }
}
