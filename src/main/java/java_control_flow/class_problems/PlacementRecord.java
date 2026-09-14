public class PlacementRecord {

    String studentName;
    String company;
    double packageLpa;

    // Constructor
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method
    public void printRecord() {
        System.out.println(
            studentName + " -> " +
            company + " @ " +
            packageLpa + " LPA"
        );
    }

    public static void main(String[] args) {

        // Create three PlacementRecord objects
        PlacementRecord record1 =
            new PlacementRecord("Ravi", "TCS", 4.5);

        PlacementRecord record2 =
            new PlacementRecord("Anitha", "Zoho", 6.2);

        PlacementRecord record3 =
            new PlacementRecord("Karthik", "Infosys", 4.0);

        // Store objects in an array
        PlacementRecord[] records = {
            record1,
            record2,
            record3
        };

        // Print each record
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
