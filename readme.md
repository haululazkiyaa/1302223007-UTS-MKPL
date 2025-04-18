# Tugas Besar Pengganti UTS MKEPL

Disusun oleh:
Muhammad Haulul Azkiyaa
NIM. 1302223007
Kelas SE-46-02

# Refactoring Checklist: Employee.java

| **Bad Smell**                     | **Checklist** | **Keterangan**                                                                      |
| --------------------------------- | ------------- | ----------------------------------------------------------------------------------- |
| Long Method                       | ✅            | Method `getAnnualIncomeTax` dipendekkan dan delegasi ke `TaxCalculator`.            |
| Primitive Obsession               | ✅            | Gunakan `LocalDate`, `Gender` enum (di `PersonalInfo`), dan class `Spouse`/`Child`. |
| Data Clumps                       | ✅            | `Spouse` & `Child` sudah dipisah jadi objek.                                        |
| Long Parameter List (Constructor) | ✅            | Gunakan `PersonalInfo` sebagai parameter object.                                    |
| Duplicate Code (setMonthlySalary) | ✅            | Logika penggajian disederhanakan dengan `switch` dan 1x multiplier.                 |
| Feature Envy                      | ✅            | Logika pajak dipindahkan ke `TaxCalculator`.                                        |

# Refactoring Checklist: TaxFunction.java

| **Bad Smell**       | **Checklist** | **Keterangan**                                              |
| ------------------- | ------------- | ----------------------------------------------------------- |
| Long Parameter List | ✅            | Digantikan dengan class `TaxData` sebagai parameter object. |
