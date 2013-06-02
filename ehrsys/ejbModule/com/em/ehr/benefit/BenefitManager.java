/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.em.ehr.benefit;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import com.em.ehr.benefit.entity.AccuCalc;
import com.em.ehr.benefit.entity.AccuStatus;
import com.em.ehr.benefit.entity.AccuStatusChangeArg;
import com.em.ehr.benefit.entity.AccuStatusView;
import com.em.ehr.benefit.entity.BenefitCalc;
import com.em.ehr.benefit.entity.BenefitCity;
import com.em.ehr.benefit.entity.BenefitCityPK;
import com.em.ehr.benefit.entity.BenefitStatus;
import com.em.ehr.benefit.entity.BenefitStatusChangeArg;
import com.em.ehr.benefit.entity.BenefitStatusView;
import com.zhjin.util.ArgMap;
import com.zhjin.util.BeanBase;
import com.zhjin.util.Utility;

/**
 * Session Bean implementation class BenefitManager
 */
@Named
@Stateless
@LocalBean
public class BenefitManager extends BeanBase {

	/**
	 * Default constructor.
	 */
	public BenefitManager() {
	}

	public void updateAccuStatus(Object obj) throws Exception {
		AccuStatusView view = (AccuStatusView) obj;

		AccuStatusChangeArg arg = new AccuStatusChangeArg();
		arg.setEmpId(view.getEmpId());
		arg.setLoginName(view.getLoginName());
		arg.setName(view.getName());
		arg.setDepId(view.getDepId());
		arg.setAccuBase(view.getAccuBase());
		arg.setAccuCity(view.getAccuCity());
		arg.setAccuCompany(view.getAccuCompany());
		arg.setAccuEnabled(view.isAccuEnabled());
		arg.setAccuFirstDate(view.getAccuFirstDate());
		arg.setAccuMoney(view.getAccuMoney());
		arg.setAccuNo(view.getAccuNo());
		arg.setBuyHouse(view.getBuyHouse());
		arg.setCreateDate(view.getCreateDate());
		arg.setCreateType(view.getCreateType());
		arg.setLoanType(view.getLoanType());
		arg.setRemark(view.getRemark());
		arg.setStopDate(view.getStopDate());
		arg.setStopReason(view.getStopReason());
		arg.setStopType(view.getStopType());
		arg = dbUtility.update(arg);

		AccuStatus status = dbUtility.getEntity(AccuStatus.class,
				view.getEmpId());
		status.setAccuBase(view.getAccuBase());
		status.setAccuCity(view.getAccuCity());
		status.setAccuCompany(view.getAccuCompany());
		status.setAccuEnabled(view.isAccuEnabled());
		status.setAccuFirstDate(view.getAccuFirstDate());
		status.setAccuMoney(view.getAccuMoney());
		status.setAccuNo(view.getAccuNo());
		status.setBuyHouse(view.getBuyHouse());
		status.setCreateDate(view.getCreateDate());
		status.setCreateType(view.getCreateType());
		status.setLoanType(view.getLoanType());
		status.setRemark(view.getRemark());
		status.setStopDate(view.getStopDate());
		status.setStopReason(view.getStopReason());
		status.setStopType(view.getStopType());
		dbUtility.update(status);
	}

	public void updateBenefitStatus(Object obj) throws Exception {
		BenefitStatusView view = (BenefitStatusView) obj;

		BenefitStatusChangeArg arg = new BenefitStatusChangeArg();
		arg.setEmpId(view.getEmpId());
		arg.setLoginName(view.getLoginName());
		arg.setName(view.getName());
		arg.setDepId(view.getDepId());
		arg.setBenefitCity(view.getBenefitCity());
		arg.setBenefitCompany(view.getBenefitCompany());
		arg.setBenefitNo(view.getBenefitNo());
		arg.setAnnuitiesBase(view.getAnnuitiesBase());
		arg.setAnnuitiesCreateDate(view.getAnnuitiesCreateDate());
		arg.setAnnuitiesCreateType(view.getAnnuitiesCreateType());
		arg.setAnnuitiesEnabled(view.isAnnuitiesEnabled());
		arg.setAnnuitiesFirstDate(view.getAnnuitiesFirstDate());
		arg.setAnnuitiesNo(view.getAnnuitiesNo());
		arg.setAnnuitiesStopDate(view.getAnnuitiesStopDate());
		arg.setAnnuitiesStopType(view.getAnnuitiesStopType());
		arg.setMedicalBase(view.getMedicalBase());
		arg.setMedicalCreateDate(view.getMedicalCreateDate());
		arg.setMedicalCreateType(view.getMedicalCreateType());
		arg.setMedicalEnabled(view.isMedicalEnabled());
		arg.setMedicalFirstDate(view.getMedicalFirstDate());
		arg.setMedicalNo(view.getMedicalNo());
		arg.setMedicalStopDate(view.getMedicalStopDate());
		arg.setMedicalStopType(view.getMedicalStopType());
		arg.setIdlenessBase(view.getIdlenessBase());
		arg.setIdlenessCode(view.getIdlenessCode());
		arg.setIdlenessCreateDate(view.getIdlenessCreateDate());
		arg.setIdlenessCreateType(view.getIdlenessCreateType());
		arg.setIdlenessEnabled(view.isIdlenessEnabled());
		arg.setIdlenessFirstDate(view.getIdlenessFirstDate());
		arg.setIdlenessStopDate(view.getIdlenessStopDate());
		arg.setIdlenessStopType(view.getIdlenessStopType());
		arg.setCompoBase(view.getCompoBase());
		arg.setCompoCreateDate(view.getCompoCreateDate());
		arg.setCompoCreateType(view.getCompoCreateType());
		arg.setCompoEnabled(view.isCompoEnabled());
		arg.setCompoFirstDate(view.getCompoFirstDate());
		arg.setCompoStopDate(view.getCompoStopDate());
		arg.setCompoStopType(view.getCompoStopType());
		arg.setBabyBase(view.getBabyBase());
		arg.setBabyCreateDate(view.getBabyCreateDate());
		arg.setBabyCreateType(view.getBabyCreateType());
		arg.setBabyEnabled(view.isBabyEnabled());
		arg.setBabyFirstDate(view.getBabyFirstDate());
		arg.setBabyStopDate(view.getBabyStopDate());
		arg.setBabyStopType(view.getBabyStopType());
		arg.setOtherCorp(view.getOtherCorp());
		arg.setOtherCreateDate(view.getOtherCreateDate());
		arg.setOtherCreateType(view.getOtherCreateType());
		arg.setOtherEnabled(view.isOtherEnabled());
		arg.setOtherFirstDate(view.getOtherFirstDate());
		arg.setOtherSelf(view.getOtherSelf());
		arg.setOtherStopDate(view.getOtherStopDate());
		arg.setOtherStopType(view.getOtherStopType());
		arg.setRemark(view.getRemark());
		arg.setSocietyRemark(view.getSocietyRemark());
		arg = dbUtility.update(arg);

		BenefitStatus status = dbUtility.getEntity(BenefitStatus.class,
				view.getEmpId());
		status.setBenefitCity(view.getBenefitCity());
		status.setBenefitCompany(view.getBenefitCompany());
		status.setBenefitNo(view.getBenefitNo());
		status.setAnnuitiesBase(view.getAnnuitiesBase());
		status.setAnnuitiesCreateDate(view.getAnnuitiesCreateDate());
		status.setAnnuitiesCreateType(view.getAnnuitiesCreateType());
		status.setAnnuitiesEnabled(view.isAnnuitiesEnabled());
		status.setAnnuitiesFirstDate(view.getAnnuitiesFirstDate());
		status.setAnnuitiesNo(view.getAnnuitiesNo());
		status.setAnnuitiesStopDate(view.getAnnuitiesStopDate());
		status.setAnnuitiesStopType(view.getAnnuitiesStopType());
		status.setMedicalBase(view.getMedicalBase());
		status.setMedicalCreateDate(view.getMedicalCreateDate());
		status.setMedicalCreateType(view.getMedicalCreateType());
		status.setMedicalEnabled(view.isMedicalEnabled());
		status.setMedicalFirstDate(view.getMedicalFirstDate());
		status.setMedicalNo(view.getMedicalNo());
		status.setMedicalStopDate(view.getMedicalStopDate());
		status.setMedicalStopType(view.getMedicalStopType());
		status.setIdlenessBase(view.getIdlenessBase());
		status.setIdlenessCode(view.getIdlenessCode());
		status.setIdlenessCreateDate(view.getIdlenessCreateDate());
		status.setIdlenessCreateType(view.getIdlenessCreateType());
		status.setIdlenessEnabled(view.isIdlenessEnabled());
		status.setIdlenessFirstDate(view.getIdlenessFirstDate());
		status.setIdlenessStopDate(view.getIdlenessStopDate());
		status.setIdlenessStopType(view.getIdlenessStopType());
		status.setCompoBase(view.getCompoBase());
		status.setCompoCreateDate(view.getCompoCreateDate());
		status.setCompoCreateType(view.getCompoCreateType());
		status.setCompoEnabled(view.isCompoEnabled());
		status.setCompoFirstDate(view.getCompoFirstDate());
		status.setCompoStopDate(view.getCompoStopDate());
		status.setCompoStopType(view.getCompoStopType());
		status.setBabyBase(view.getBabyBase());
		status.setBabyCreateDate(view.getBabyCreateDate());
		status.setBabyCreateType(view.getBabyCreateType());
		status.setBabyEnabled(view.isBabyEnabled());
		status.setBabyFirstDate(view.getBabyFirstDate());
		status.setBabyStopDate(view.getBabyStopDate());
		status.setBabyStopType(view.getBabyStopType());
		status.setOtherCorp(view.getOtherCorp());
		status.setOtherCreateDate(view.getOtherCreateDate());
		status.setOtherCreateType(view.getOtherCreateType());
		status.setOtherEnabled(view.isOtherEnabled());
		status.setOtherFirstDate(view.getOtherFirstDate());
		status.setOtherSelf(view.getOtherSelf());
		status.setOtherStopDate(view.getOtherStopDate());
		status.setOtherStopType(view.getOtherStopType());
		status.setRemark(view.getRemark());
		status.setSocietyRemark(view.getSocietyRemark());
		dbUtility.update(status);
	}

	public AccuStatusView changeAccuStatusFromCalc(Object obj) throws Exception {
		checkAccuSubmit();
		AccuCalc calc = (AccuCalc) obj;
		return dbUtility.getData(
				"select * from accustatusview where empId = :empId",
				AccuStatusView.class,
				new ArgMap().add("empId", calc.getEmpId()));
	}

	public BenefitStatusView changeBenefitStatusFromCalc(Object obj)
			throws Exception {
		checkBenefitSubmit();
		BenefitCalc calc = (BenefitCalc) obj;
		return dbUtility.getData(
				"select * from benefitstatusview where empId = :empId",
				BenefitStatusView.class,
				new ArgMap().add("empId", calc.getEmpId()));
	}

	public void accuCalc(Object obj) throws Exception {
		checkAccuSubmit();
		String ret = dbUtility.executeStoreProcedure(
				"{call hrsp_accucalc(:userId, :retVal)}",
				new ArgMap().add("userId", this.getUser().getUserId()));
		Utility.showAlertMessage(ret);
	}

	public void accuSubmit(Object obj) throws Exception {
		checkAccuSubmit();
		dbUtility
				.executeUpdate(
						"update accucalc set submit = 1 "
								+ "where (company, area) in (select company, area from benefitcity where enabled = 1 and accumanagerempid = :empId)",
						new ArgMap().add("empId", this.getUser().getUserId()));
		List<BenefitCity> _cityList = dbUtility
				.getDataList(
						"select * from benefitcity where enabled = 1 and accumanagerempid = :empId",
						BenefitCity.class,
						new ArgMap().add("empId", this.getUser().getUserId()));
		for (BenefitCity city : _cityList) {
			city.setAccuSubmit(true);
			city.setAccuSubmitEmpId(this.getUser().getUserId());
			city.setAccuSubmitLoginName(this.getUser().getLoginName());
			city.setAccuSubmitName(this.getUser().getName());
			city.setAccuSubmitTime(new Date());
			dbUtility.update(city);
		}
		Utility.showAlertMessage("公积金签发完成!");
	}

	public void accuUnSubmit(Object obj) throws Exception {
		BenefitCity currentCity = (BenefitCity) obj;
		currentCity = dbUtility.getEntity(BenefitCity.class, new BenefitCityPK(
				currentCity.getArea(), currentCity.getCompany()));
		if (!currentCity.isAccuSubmit()) {
			throw new Exception("公积金未签发，不能反签发!");
		}
		List<BenefitCity> _cityList = dbUtility
				.getDataList(
						"select * from benefitcity where enabled = 1 and accumanagerempid = :empId",
						BenefitCity.class,
						new ArgMap().add("empId",
								currentCity.getAccuManagerEmpId()));
		for (BenefitCity city : _cityList) {
			city.setAccuSubmit(false);
			city.setAccuSubmitEmpId(this.getUser().getUserId());
			city.setAccuSubmitLoginName(this.getUser().getLoginName());
			city.setAccuSubmitName(this.getUser().getName());
			city.setAccuSubmitTime(new Date());
			dbUtility.update(city);
		}
		Utility.showAlertMessage("公积金反签发完成!");
	}

	public void benefitSubmit(Object obj) throws Exception {
		checkBenefitSubmit();
		dbUtility
				.executeUpdate(
						"update benefitcalc set submit = 1 "
								+ "where (company, area) in (select company, area from benefitcity where enabled = 1 and benefitmanagerempid = :empId)",
						new ArgMap().add("empId", this.getUser().getUserId()));
		List<BenefitCity> _cityList = dbUtility
				.getDataList(
						"select * from benefitcity where enabled = 1 and benefitmanagerempid = :empId",
						BenefitCity.class,
						new ArgMap().add("empId", this.getUser().getUserId()));
		for (BenefitCity city : _cityList) {
			city.setBenefitSubmit(true);
			city.setBenefitSubmitEmpId(this.getUser().getUserId());
			city.setBenefitSubmitLoginName(this.getUser().getLoginName());
			city.setBenefitSubmitName(this.getUser().getName());
			city.setBenefitSubmitTime(new Date());
			dbUtility.update(city);
		}
		Utility.showAlertMessage("社保签发完成!");
	}

	public void benefitUnSubmit(Object obj) throws Exception {
		BenefitCity currentCity = (BenefitCity) obj;
		currentCity = dbUtility.getEntity(BenefitCity.class, new BenefitCityPK(
				currentCity.getArea(), currentCity.getCompany()));
		if (!currentCity.isBenefitSubmit()) {
			throw new Exception("社保未签发，不能反签发!");
		}
		List<BenefitCity> _cityList = dbUtility
				.getDataList(
						"select * from benefitcity where enabled = 1 and benefitmanagerempid = :empId",
						BenefitCity.class,
						new ArgMap().add("empId",
								currentCity.getBenefitManagerEmpId()));
		for (BenefitCity city : _cityList) {
			city.setBenefitSubmit(false);
			city.setBenefitSubmitEmpId(this.getUser().getUserId());
			city.setBenefitSubmitLoginName(this.getUser().getLoginName());
			city.setBenefitSubmitName(this.getUser().getName());
			city.setBenefitSubmitTime(new Date());
			dbUtility.update(city);
		}
		Utility.showAlertMessage("社保反签发完成!");
	}

	public void benefitCalc(Object obj) throws Exception {
		checkBenefitSubmit();
		String ret = dbUtility.executeStoreProcedure(
				"{call hrsp_benefitcalc(:userId, :retVal)}",
				new ArgMap().add("userId", this.getUser().getUserId()));
		Utility.showAlertMessage(ret);
	}

	public void checkAccuSubmit() throws Exception {
		if (dbUtility
				.exists("select * from benefitcity where accusubmit = 1 and accumanagerempid = :empId",
						new ArgMap().add("empId", this.getUser().getUserId()))) {
			throw new Exception("公积金已经签发，不能操作!");
		}
	}

	public void checkBenefitSubmit() throws Exception {
		if (dbUtility
				.exists("select * from benefitcity where benefitsubmit = 1 and benefitmanagerempid = :empId",
						new ArgMap().add("empId", this.getUser().getUserId()))) {
			throw new Exception("社保已经签发，不能操作!");
		}
	}

	public Object initUpdateAccuCalc(Object obj) throws Exception {
		checkAccuSubmit();
		return obj;
	}

	public void accuRemeChange(ValueChangeEvent event) throws Exception {
		AccuCalc calc = (AccuCalc) this.getWindowData()
				.getDefaultObjectEditData().getEditData();
		calc.setAccuSelfSum(Utility.addBigDecimal(calc.getAccuSelf(),
				calc.getAccuSelfReme()));
		calc.setAccuCorpSum(Utility.addBigDecimal(calc.getAccuCorp(),
				calc.getAccuCorpReme()));
	}

	public Object initUpdateBenefitCalc(Object obj) throws Exception {
		checkBenefitSubmit();
		return obj;
	}

	public void benefitRemeChange(ValueChangeEvent event) throws Exception {
		BenefitCalc calc = (BenefitCalc) this.getWindowData()
				.getDefaultObjectEditData().getEditData();
		calc.setMedicalSelfSum(Utility.addBigDecimal(calc.getMedicalSelf(),
				calc.getMedicalSelfReme()));
		calc.setMedicalCorpSum(Utility.addBigDecimal(calc.getMedicalCorp(),
				calc.getMedicalCorpReme()));

		calc.setAnnuitiesSelfSum(Utility.addBigDecimal(calc.getAnnuitiesSelf(),
				calc.getAnnuitiesSelfReme()));
		calc.setAnnuitiesCorpSum(Utility.addBigDecimal(calc.getAnnuitiesCorp(),
				calc.getAnnuitiesCorpReme()));

		calc.setIdlenessSelfSum(Utility.addBigDecimal(calc.getIdlenessSelf(),
				calc.getIdlenessSelfReme()));
		calc.setIdlenessCorpSum(Utility.addBigDecimal(calc.getIdlenessCorp(),
				calc.getIdlenessCorpReme()));

		calc.setCompoSelfSum(Utility.addBigDecimal(calc.getCompoSelf(),
				calc.getCompoSelfReme()));
		calc.setCompoCorpSum(Utility.addBigDecimal(calc.getCompoCorp(),
				calc.getCompoCorpReme()));

		calc.setBabySelfSum(Utility.addBigDecimal(calc.getBabySelf(),
				calc.getBabySelfReme()));
		calc.setBabyCorpSum(Utility.addBigDecimal(calc.getBabyCorp(),
				calc.getBabyCorpReme()));
	}

	public void benefitClose(Object obj) throws Exception {
		if (dbUtility
				.exists("select * from benefitcity where accusubmit = 0 or benefitsubmit = 0",
						null)) {
			throw new Exception("公积金和社保未全部签发，不能封帐!");
		}
		String ret = dbUtility.executeStoreProcedure(
				"{call hrsp_benefitclose(:userId, :retVal)}",
				new ArgMap().add("userId", this.getUser().getUserId()));
		Utility.showAlertMessage(ret);
	}

}
