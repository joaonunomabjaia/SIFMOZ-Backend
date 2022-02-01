package sifmoz.backend

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
        patch "/inventory/close/$id(.$format)?"(controller:'inventory', action:'close')
        post "/patient/search(.$format)?"(controller:'patient', action:'search')
        get "/patient/clinic/$clinicId(.$format)?"(controller:'patient', action:'getByClinicId')
        get "/stockEntrance/clinic/$clinicId(.$format)?"(controller:'stockEntrance', action:'getByClinicId')
        get "/inventory/clinic/$clinicId(.$format)?"(controller:'inventory', action:'getByClinicId')
        get "/patientServiceIdentifier/clinic/$clinicId(.$format)?"(controller:'patientServiceIdentifier', action:'getByClinicId')
        get "/patientServiceIdentifier/patient/$patientId(.$format)?"(controller:'patientServiceIdentifier', action:'getByPatientId')
        get "/episode/clinic/$clinicId(.$format)?"(controller:'episode', action:'getByClinicId')
        get "/episode/identifier/$identifierId(.$format)?"(controller:'episode', action:'getByIdentifierId')
        get "/doctor/clinic/$clinicId(.$format)?"(controller:'doctor', action:'getByClinicId')
        get "/patientVisit/clinic/$clinicId(.$format)?"(controller:'patientVisit', action:'getAllByClinicId')
        get "/patientVisitDetails/clinic/$clinicId(.$format)?"(controller:'patientVisitDetails', action:'getAllByClinicId')
        get "/patientVisitDetails/episode/$episodeId(.$format)?"(controller:'patientVisitDetails', action:'getAllByEpisodeId')
        get "/prescription/clinic/$clinicId(.$format)?"(controller:'prescription', action:'getAllByClinicId')
        get "/pregnancyScreening/patientVisit/$patientVisitId(.$format)?"(controller:'pregnancyScreening', action:'getAllByPatientVisit')
        get "/prescription/visits/$pvdsId(.$format)?"(controller:'prescription', action:'getByVisitId')
        get "/pack/clinic/$clinicId(.$format)?"(controller:'pack', action:'getAllByClinicId')
        get "/pack/patientVisitDetails/$patientVisitDetailsId(.$format)?"(controller:'pack', action:'getAllByPatientVisitDetailsId')
        get "/packagedDrug/pack/$packId(.$format)?"(controller:'packagedDrug', action:'getAllByPackId')
        get "/prescribedDrug/prescription/$prescriptionId(.$format)?"(controller:'prescribedDrug', action:'getAllByPrescriptionId')
        get "/prescriptionDetail/prescription/$prescriptionId(.$format)?"(controller:'prescriptionDetail', action:'getAllByPrescriptionId')
        get "/patientVisit/patient/$patientId(.$format)?"(controller:'patientVisit', action:'getByPatientId')
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
