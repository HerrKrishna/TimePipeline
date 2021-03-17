
/* First created by JCasGen Tue Feb 23 15:14:57 CET 2021 */
package de.unihd.dbs.uima.types.dornseifftime;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Feb 23 15:14:57 CET 2021
 * @generated */
public class Dornseiff_category_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Dornseiff_category.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unihd.dbs.uima.types.dornseifftime.Dornseiff_category");
 
  /** @generated */
  final Feature casFeat_category_name;
  /** @generated */
  final int     casFeatCode_category_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCategory_name(int addr) {
        if (featOkTst && casFeat_category_name == null)
      jcas.throwFeatMissing("category_name", "de.unihd.dbs.uima.types.dornseifftime.Dornseiff_category");
    return ll_cas.ll_getStringValue(addr, casFeatCode_category_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCategory_name(int addr, String v) {
        if (featOkTst && casFeat_category_name == null)
      jcas.throwFeatMissing("category_name", "de.unihd.dbs.uima.types.dornseifftime.Dornseiff_category");
    ll_cas.ll_setStringValue(addr, casFeatCode_category_name, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Dornseiff_category_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_category_name = jcas.getRequiredFeatureDE(casType, "category_name", "uima.cas.String", featOkTst);
    casFeatCode_category_name  = (null == casFeat_category_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_category_name).getCode();

  }
}



    