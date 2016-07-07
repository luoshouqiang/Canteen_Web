package com.canteen.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.manage.entity.CardUseDetail;
import com.canteen.manage.entity.CardUseDetailPK;
import com.canteen.manage.repositories.CardUseDetailRepository;

@Service
public class CardUseDetailService {
	
	@Autowired
	CardUseDetailRepository cardUseDetailRepository;
	
	public CardUseDetail findByCardIdAndRuleId(int cardId,int attributeId){
		CardUseDetailPK cardUseDetailPK=new CardUseDetailPK();
		cardUseDetailPK.setCardId(cardId);
		cardUseDetailPK.setAttributeId(attributeId);
		return cardUseDetailRepository.findOne(cardUseDetailPK);
	}
	
	public void saveCardDetail(int cardId,int attributeId,int state,String value){
		CardUseDetailPK cardUseDetailPK=new CardUseDetailPK();
		cardUseDetailPK.setCardId(cardId);
		cardUseDetailPK.setAttributeId(attributeId);
		CardUseDetail detail =new CardUseDetail();
		detail.setId(cardUseDetailPK);
		detail.setCudState((short)state);
		detail.setCudAttvalue(value);
		cardUseDetailRepository.save(detail);
	}
	public void saveCardDetail(CardUseDetail detail){
		cardUseDetailRepository.save(detail);
	}
	
}
