/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gilbert.solorzano
 */

@XmlSeeAlso(ExNVProperty.class)
public class ExNVProperties {
    private ArrayList<ExNVProperty> properties=new ArrayList<ExNVProperty>();
    private int level=5;
    
    public ExNVProperties(){}

    @XmlTransient
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    
    @XmlElement(name=AppExportS.PROPERTY)
    public ArrayList<ExNVProperty> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<ExNVProperty> properties) {
        this.properties = properties;
    }
    
    public String whatIsDifferent(ExNVProperties obj){
        if( this.equals(obj) ) return AppExportS._U;
        
        StringBuilder bud = new StringBuilder();
        
        bud.append(AppExportS.I[level]).append(AppExportS.PROPERTIES);
        level++;
        for(ExNVProperty value:properties){
            value.setLevel(level);
            boolean fnd=false;
            for(ExNVProperty _value:obj.getProperties()){
                if(value.getName().equals(_value.getName())){
                    fnd=true;
                    bud.append(value.whatIsDifferent(_value));
                }
            }
            if(!fnd){
                bud.append(AppExportS.I[level]).append(AppExportS.SRC).append(value);
            }
        }
        
        for(ExNVProperty value:obj.getProperties()){
                value.setLevel(level);
            boolean fnd=false;
            for(ExNVProperty _value:properties){
                if(value.getName().equals(_value.getName())){
                    fnd=true;
                }
            }
            if(!fnd){
                bud.append(AppExportS.I[level]).append(AppExportS.DEST).append(value);
            }
        }
        level--;
        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.I[level]).append(AppExportS.PROPERTIES);
        level++;
        for(ExNVProperty prop:properties){prop.setLevel(level);bud.append(prop);}
        level--;
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.properties != null ? this.properties.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExNVProperties other = (ExNVProperties) obj;
        
        if(properties.size() != other.getProperties().size()) return false;
        
        for(ExNVProperty value:properties){
            value.setLevel(level);
            boolean fnd=false;
            for(ExNVProperty _value:other.getProperties()){
                if(value.getName().equals(_value.getName())){
                    if(value.equals(_value)) fnd=true;
                }
            }
            if(!fnd){
                return false;
            }
        }
        return true;
    }
    
    
}

/*
 * 
                                    <properties>
                                        <property name="uri-suffix-scheme" value="custom-expression"/>
                                        <property name="suffix-key" value="${}"/>
                                    </properties>
 * 
 */