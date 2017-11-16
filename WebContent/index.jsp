<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-bt">
    <head>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script> 

    </head>
    <body>
        <div class="card">
            <div class="card-body">
            
              <h4 class="card-title">Mix de Produção</h4>
              <p class="card-text">Solução para Otimização da Produção de Doces.</p>
              
              <div class="btn-group" data-toggle="buttons">
                  <label class="btn btn-secondary">
                    <input type="radio" name="options" id="option1" autocomplete="off"> Maximização
                  </label>
                  <label class="btn btn-secondary">
                    <input type="radio" name="options" id="option2" autocomplete="off"> Minimização
                  </label>
                </div>

                <br>    

                <br>
                <form action = "Controller" method="get">
                <div class="row">
                        <p class="card-text"> Função Objetivo</p>
                        <div class="col-xs-6 col-1 form-group">
                            <input class="form-control form-control-sm" type="text" id="f1" name="f1"/>
                        </div>
                        <div class="col-xs-6 col-1 form-group">
                            <label>Brigadeiro</label> 
                        </div>

                        <div class="col-xs-6 col-1 form-group">
                            <input class="form-control form-control-sm" type="text" id="f2" name="f2"/>
                        </div>
                        <div class="col-xs-6 col-1 form-group">
                            <label>Quindim</label> 
                        </div>

                        <div class="col-xs-6 col-1 form-group">
                            <input class="form-control form-control-sm" type="text" id="f3" name="f3"/>
                        </div>
                        <div class="col-xs-6 col-1 form-group">
                            <label>Cajuzinho</label> 
                        </div>


                        <div class="col-xs-6 col-1 form-group">
                            <input class="form-control form-control-sm" type="text" id="f4" name="f4"/>
                        </div>
                        <div class="col-xs-6 col-1 form-group">
                            <label>Casadinho</label>
                        </div>

                        <div class="col-xs-6 col-1 form-group">     
                            <input class="form-control form-control-sm" type="text" id="f5" name="f5"/>
                        </div>
                        <div class="col-xs-6 col-1 form-group">
                            <label>Beijinho</label> 
                        </div>

   
                                            
                    </div>
                </div>
                </div>
                



                <br>
                
                <table class="table table-inverse">
                        <thead>
                          <tr>
                            <th><center>#</center></th>
                            <th><center>Brigadeiro</center></th>
                            <th><center>Quindim</center></th>
                            <th><center>Cajuzinho</center></th>
                            <th><center>Casadinho</center></th>
                            <th><center>Beijinho</center></th>
                            <th><center>Restrição</center></th>
                            <th><center>Disponibilidade</center></th>
                      
                          </tr>
                        </thead>
                      
                        <tbody>
                          <tr>
                            <th scope="row"><center>Ovos</center></th>
                            <td>             
                                  <input class="form-control form-control-sm" type="text" id="r00" name="r00"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r01" name="r01"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r02" name="r02"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r03" name="r03"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r04" name="r04"/>
                            </td>
                            <td>    
                                <center>
                                    <select class="selectpicker" id="r05" name="r05">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>                
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r06" name="r06"/>
                            </td>
                          </tr>
                      
                          <tr>
                            <th scope="row"><center>Côco</center></th>
                                  <td>             
                                  <input class="form-control form-control-sm" type="text"id="r10" name="r10"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r11" name="r11"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r12" name="r12"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r13" name="r13"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r14" name="r14"/>
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker"id="r15" name="r15">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text"id="r16" name="r16"/>
                            </td>
                          </tr>
                      
                          <tr>
                            <th scope="row"><center>Cravo</center></th>
                            <td>             
                                  <input class="form-control form-control-sm" type="text" id="r20" name="r20"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r21" name="r21"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r22" name="r22"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r23" name="r23"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r24" name="r24"/>
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker" id="r25" name="r25">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r26" name="r26"/>
                            </td>
                          </tr>
                      
                          <tr>
                            <th scope="row"><center>Açúcar</center></th>
                                  <td>             
                                  <input class="form-control form-control-sm" type="text" id="r30" name="r30"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r31" name="r31"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r32" name="r32"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r33" name="r33"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r34" name="r34"/>
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker" id="r35" name="r35">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r36"  name="r36"/>
                            </td>
                          </tr>

                      
                          <tr>
                            <th scope="row"><center>Amendoim</center></th>
                                  <td>             
                                  <input class="form-control form-control-sm" type="text" id="r40"  name="r40"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r41" name="r41"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r42" name="r42"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r43" name="r43"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r44" name="r44">
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker" id="r45" name="r45">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r46" name="r46"/>
                            </td>
                          </tr>
                      
                          <tr>
                            <th scope="row"><center>Leite de Côco</center></th>
                                  <td>             
                                  <input class="form-control form-control-sm" type="text" id="r50" name="r50"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r51"  name="r51"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r52"  name="r52"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r53" name="r53"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r54" name="r54"/>
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker" id="r55" name="r55">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r56" name="r56"/>
                            </td>
                          </tr>
                          <tr>
                            <th scope="row"><center>Leite Condensado</center></th>
                                  <td>             
                                  <input class="form-control form-control-sm" type="text" id="r60" name="r60"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r61" name="r61"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r62" name="r62"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r63" name="r63"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r64" name="r64"/>
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker" id="r65" name="r65">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r66" name="r66"/>
                            </td>
                          </tr>
                          <tr>
                            <th scope="row"><center>Chocolate em Pó</center></th>
                                  <td>             
                                  <input class="form-control form-control-sm" type="text" id="r70" name="r70"/>
                              </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r71" name="r71"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r72" name="r72"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r73" name="r73"/>
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r74" name="r74"/>
                            </td>
                            <td>
                                <center>
                                    <select class="selectpicker" id="r75" name="r75">
                                            <option>=</option>
                                            <option>>=</option>
                                            <option> >= </option>
                                          </select>
                                </center>  
                            </td>
                            <td>
                                  <input class="form-control form-control-sm" type="text" id="r76" name = "r76"/>
                            </td>
                          </tr>
                      
                        </tbody>
                      </table>
                      
                                        <center>
                  <div class="row">
                        <div class="col-xs-6 col-1 form-group">
                              <center><label>Brigadeiro</label></center>
                        </div>

                        <center>
                              <select class="selectpicker" id="v1" name="v1">
                                    <option>=</option>
                                    <option>>=</option>
                                    <option> >= </option>
                              </select>
                        </center>
                        <div class="col-xs-6 col-1 form-group">
                              <input class="form-control form-control-sm" type="text" id="v2" name="v2"/>
                        </div>

                        <div class="col-xs-6 col-1 form-group">
                              <center><label>Quindim</label></center>
                        </div>

                        <center>
                              <select class="selectpicker" id="v4" name="v4">
                                    <option>=</option>
                                    <option>>=</option>
                                    <option> >= </option>
                              </select>
                        </center>
                        <div class="col-xs-6 col-1 form-group">
                              <input class="form-control form-control-sm" type="text" id="v5" name="v5"/>
                        </div>


                        <div class="col-xs-6 col-1 form-group">
                              <center><label>Cajuzinho</label></center>
                        </div>

                        <center>
                              <select class="selectpicker" id="v6" name="v6">
                                    <option>=</option>
                                    <option>>=</option>
                                    <option> >= </option>
                              </select>
                        </center>
                        <div class="col-xs-6 col-1 form-group">
                              <input class="form-control form-control-sm" type="text" id="v7" name="v7"/>
                        </div>

                        <div class="col-xs-6 col-1 form-group">
                              <center><label>Casadinho</label></center>
                        </div>

                        <center>
                              <select class="selectpicker" id="v8" name="v8">
                                    <option>=</option>
                                    <option>>=</option>
                                    <option> >= </option>
                              </select>
                        </center>
                        <div class="col-xs-6 col-1 form-group">
                              <input class="form-control form-control-sm" type="text" id="v9" name="v9"/>
                        </div>

                        <div class="col-xs-6 col-1 form-group">
                              <center><label>Beijinho</label></center>
                        </div>

                        <center>
                              <select class="selectpicker" id="v10" name="v10">
                                    <option>=</option>
                                    <option>>=</option>
                                    <option> >= </option>
                              </select>
                        </center>
                        <div class="col-xs-6 col-1 form-group">
                              <input class="form-control form-control-sm" type="text" id="v11" name="v11"/>
                        </div>
                        
                  </div>
                  </center>
	                      
		            	<center><button type="submit" class="btn btn-primary pull-center">Resolver</button></center>
		            	
		            	
		            	
                      </form>



            
            
            
            <br>
          <div class="alert alert-success" role="alert">
              <h4 class="alert-heading"></h4>
              <p></p>
              <hr>
              <p class="mb-0"></p>
          </div>
  
         
          
    </body>
    <%--
    <%
    	String a = (String) request.getAttribute("f05");
    	out.println(a);
    	out.println("<h1> OI </h1>");
    %>
    --%>

</html>