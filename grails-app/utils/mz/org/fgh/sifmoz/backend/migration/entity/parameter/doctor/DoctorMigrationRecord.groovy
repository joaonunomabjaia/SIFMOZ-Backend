package mz.org.fgh.sifmoz.backend.migration.entity.parameter.doctor

import com.fasterxml.jackson.annotation.JsonIgnore
import mz.org.fgh.sifmoz.backend.clinic.Clinic
import mz.org.fgh.sifmoz.backend.clinicSector.ClinicSector
import mz.org.fgh.sifmoz.backend.clinicSectorType.ClinicSectorType
import mz.org.fgh.sifmoz.backend.dispenseType.DispenseType
import mz.org.fgh.sifmoz.backend.doctor.Doctor
import mz.org.fgh.sifmoz.backend.migration.base.record.AbstractMigrationRecord
import mz.org.fgh.sifmoz.backend.migration.base.record.MigratedRecord
import mz.org.fgh.sifmoz.backend.migrationLog.MigrationLog
import mz.org.fgh.sifmoz.backend.utilities.Utilities

class DoctorMigrationRecord extends AbstractMigrationRecord {

     String emailaddress

     String firstname

     Integer id

     String lastname

     String mobileno

     char modified

     String telephoneno

     boolean active

     int category

    String migration_status

    @Override
    public List<MigrationLog> migrate() {
        return null;
    }

    @Override
    public void updateIDMEDInfo() {

    }

    @Override
    int getId() {
        List<MigrationLog> logs = new ArrayList<>()
        getMigratedRecord().setFirstnames(this.firstname)
        getMigratedRecord().setLastname(this.lastname)
        getMigratedRecord().setGender("TBD")
        getMigratedRecord().setTelephone(this.telephoneno)
        getMigratedRecord().setEmail(this.emailaddress)
        getMigratedRecord().setClinic(Clinic.findByMainClinic(true))
        getMigratedRecord().setActive(true)

        if (Utilities.listHasElements(logs)) return logs

        Doctor.withTransaction {
            getMigratedRecord().validate()
            if (!getMigratedRecord().hasErrors()) {
                getMigratedRecord().save(flush: true)
            } else {
                logs.addAll(generateUnknowMigrationLog(this, getMigratedRecord().getErrors().toString()))
                return logs
            }
        }
        return logs
    }

    @Override
    String getEntityName() {
        return "doctor"
    }

    @Override
    Doctor initMigratedRecord() {
        return new Doctor();
    }

    @Override
    Doctor getMigratedRecord() {
        return (Doctor) super.getMigratedRecord();
    }
}
