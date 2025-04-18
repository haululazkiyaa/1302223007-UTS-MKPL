package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(TaxData data) {
		int monthlyIncome = data.getMonthlySalary() + data.getOtherMonthlyIncome();
		int annualIncome = monthlyIncome * data.getMonthsWorked();
		int taxableIncome = annualIncome - data.getAnnualDeductible();
	
		int tax = 0;
		if (taxableIncome <= 50000000) {
			tax = (int)(taxableIncome * 0.05);
		} else if (taxableIncome <= 250000000) {
			tax = (int)(50000000 * 0.05 + (taxableIncome - 50000000) * 0.15);
		} else if (taxableIncome <= 500000000) {
			tax = (int)(50000000 * 0.05 + 200000000 * 0.15 + (taxableIncome - 250000000) * 0.25);
		} else {
			tax = (int)(50000000 * 0.05 + 200000000 * 0.15 + 250000000 * 0.25 + (taxableIncome - 500000000) * 0.3);
		}
	
		// Pengurangan pajak
		if (data.isMarried()) {
			tax -= 4500000;
		}
	
		tax -= 4500000 * data.getNumberOfChildren();
	
		// Cegah negatif
		return Math.max(tax, 0);
	}
}
