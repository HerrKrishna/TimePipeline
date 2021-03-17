

/* First created by JCasGen Tue Feb 23 15:14:57 CET 2021 */
package de.unihd.dbs.uima.types.dornseifftime;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Feb 23 15:14:57 CET 2021
 * XML source: /home/christoph/eclipse-workspace/TimePipeline/target/jcasgen/typesystem.xml
 * @generated */
public class Dornseiff_category extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Dornseiff_category.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Dornseiff_category() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Dornseiff_category(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Dornseiff_category(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Dornseiff_category(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: category_name

  /** getter for category_name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCategory_name() {
    if (Dornseiff_category_Type.featOkTst && ((Dornseiff_category_Type)jcasType).casFeat_category_name == null)
      jcasType.jcas.throwFeatMissing("category_name", "de.unihd.dbs.uima.types.dornseifftime.Dornseiff_category");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Dornseiff_category_Type)jcasType).casFeatCode_category_name);}
    
  /** setter for category_name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCategory_name(String v) {
    if (Dornseiff_category_Type.featOkTst && ((Dornseiff_category_Type)jcasType).casFeat_category_name == null)
      jcasType.jcas.throwFeatMissing("category_name", "de.unihd.dbs.uima.types.dornseifftime.Dornseiff_category");
    jcasType.ll_cas.ll_setStringValue(addr, ((Dornseiff_category_Type)jcasType).casFeatCode_category_name, v);}    
  }

    