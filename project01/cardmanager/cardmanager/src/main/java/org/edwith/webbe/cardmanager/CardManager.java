package org.edwith.webbe.cardmanager;

import java.util.List;
import org.edwith.webbe.cardmanager.dao.BusinessCardManagerDao;
import org.edwith.webbe.cardmanager.dto.BusinessCard;
import org.edwith.webbe.cardmanager.ui.CardManagerUI;

public class CardManager {
  public static void main(String[] args){
    CardManagerUI cardManagerUI = CardManagerUI.getInstance();
    BusinessCardManagerDao businessCardManagerDao = new BusinessCardManagerDao();

    while_loop:
      while(true) {
        cardManagerUI.printMainMenu();
        int menuNumber = cardManagerUI.getMenuNumber();
        switch(menuNumber){
          case 1 :
            BusinessCard businessCard = cardManagerUI.inputBusinessCard();
            // businessCardManagerDao.addBusinessCard(businessCard);
            int addCounter = businessCardManagerDao.addBusinessCard(businessCard);

            if (addCounter == 1) { // insert 성공 여부에 따라 메시지 추가
              System.out.println("------------------------");
              System.out.println("값 입력에 성공하였습니다.");
            } else {
              System.out.println("------------------------");
              System.out.println("값 입력에 실패하였습니다.");
            }

            break;
          case 2 :
            String searchKeyword = cardManagerUI.getSearchKeyword();
            List<BusinessCard> businessCardList = businessCardManagerDao.searchBusinessCard(searchKeyword);
            if (businessCardList.size() != 0) { // 검색결과 없을 시 메시지 추가
              cardManagerUI.printBusinessCards(businessCardList);
            } else {
              System.out.println("------------------------");
              System.out.println("검색 결과가 없습니다.");
            }
            break;
          case 3 :
            cardManagerUI.printExitMessage();
            break while_loop;
          default:
            cardManagerUI.printErrorMessage();
            break;
        }
      }
  }
}
