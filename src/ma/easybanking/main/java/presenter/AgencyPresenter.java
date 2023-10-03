package ma.easybanking.main.java.presenter;

import ma.easybanking.main.java.model.AgencyModel;
import ma.easybanking.main.java.model.DTO.Agency;
import ma.easybanking.main.java.view.AgencyView;

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
        if(agencyModel.deleteAgency(agencyView.getAgency()))
        {
            agencyView.displaySuccessMsg("Agence supprimée avec succès");
        }else{
            agencyView.displayErrorMsg("Erreur lors de la suppression");
        }
    }

}
