<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="work-area">
	


	<form action="/admin/receipt/create"  method="POST">
	
	
	<div id="container" role="main">
	
	
	
	
	건물정보 : <input type="text" name="tatemonojoho"/></br></br>
	
	이름 : <input type="text" name="namae"/></br></br>
	
	생년월일 : <input type="text" name="senengatsunichi"/></br></br>
	
	국적 : <input type="text" name="kokuseki"/></br></br>
	
	재류카드FLAG : <input type="text" name="재류카드FLAG"/></br></br>
	
	외국입입주일 : <input type="text" name="gaikokunyukyobi"/></br></br>
	
	재류자격 : <input type="text" name="zairyushikaku"/></br></br>
	
	재류기간 : <input type="text" name="zairyukikan"/></br></br>
	
	재류만료일 : <input type="text" name="zairyumanryobi"/></br></br>
	
	<div class="join_row join_moblie" id="movDiv">

		<h3 class="join_title">
			<label for="phoneNo">전화번호</label>
		
		</h3>
		 
		
		 
		<div class="ps_box country_code">
		<select id="nationNo" name="nationNo" class="sel" aria-label="Enter Phone Number">
                                        
                                       <option value="81">
                                            JAPAN +81
                                        </option>
                                        <option value="44">
                                            United Kingdom +44
                                        </option>
                                        <option value="1">
                                            United States/Canada  +1
                                        
                        </select>
		
		</br>
		</br>
	</div>
	<div class="int_mobile_area">
						<span class="ps_box int_mobile">
							<input type="tel" id="phoneNo" name="fonbango" placeholder="Enter Phone Number" aria-label="Enter Phone Number" class="int" maxlength="16">
							<label for="phoneNo" class="lbl"></label>
						</span>
                        
                        
                    </div>
                    </br>
                    </br>
	
	우편번호 : <input name="zipcode1" id="zipcode" type="text" size="7" maxlength="7" name="yubinbango"></br></br>
	
	
	
	<div class="home_address">
    	<label for="jusho">주소</label>
  	  		<input type="text" class="int" id="mail">
   		


		<label for=shosaijusho">상세 주소</label>
		 	<input type="text" class="int" id="mail"> </br></br>
	   
	</div>
	직장명 : <input type="text" name="shokubana"/></br></br>
	

	<label for="shokobanajusho" class="form-label">직장주소:</label>
	    <input type="email" class="int" id="exampleInputEmail2" aria-describedby="emailHelp"></br></br>
	    
	    <div = checklist>
	    
	    
	수입증명서 : 

	 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
	  <label class="form-check-label" for="flexRadioDefault1">
		有
  </label>
  
	 <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
	  <label class="form-check-label" for="flexRadioDefault2">
	   	無
		  </label>
		  
		  </br>
		  </br>
		  </div>
	
	연수입 : <input type="text" name="nenshu"/></br></br>
	
	 </div>
	
	
	
  </div>
	

	
	
	
	
	<button type="button" class="Reset">Reset</button>
	
	<button type="submit" class="btn btn-dark">Ok</button>
	




</table>


</form>

