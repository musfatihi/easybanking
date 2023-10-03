package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.AgencyModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.view.AgencyView;

import java.util.Optional;

public class AgencyPresenter {
    private AgencyModel agencyModel;
    private AgencyView agencyView;

    public AgencyPresenter(AgencyView agencyView,AgencyModel agencyModel){
        this.agencyView = agencyView;
        this.agencyModel = agencyModel;
    }

    public void saveAgency(){
        Agency agency = agencyModel.saveAgency(agencyView.saveAgency());
        agencyView.displayAgency(agency);
    }

    public void deleteAgency(){
        if(agencyModel.deleteAgency(agencyView.getAgency("Suppression d'une agence")))
        {
            agencyView.displaySuccessMsg("Agence supprimée avec succès");
        }else{
            agencyView.displayErrorMsg("Erreur lors de la suppression");
        }
    }

    public void findAgencyByCode(){

        Optional<Agency> agencyOptional = agencyModel.findAgencyByCode(agencyView.getAgency("Checher une Agence"));

        if(agencyOptional.isPresent()){
            agencyView.displayAgency(agencyOptional.get());
        }

    }

}
