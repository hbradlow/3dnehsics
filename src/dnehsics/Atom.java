/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dnehsics;

import java.util.List;
import javax.media.j3d.BranchGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

/**
 *
 * @author henry
 */
//Using equation for charge density: 4(x^3)e^(-x^4)
//integral: -e^(-x^4)
public class Atom extends Body{
    protected int numElectrons;
    protected int numProtons;
    public Atom(Vector3f p, Vector3f v, float r, int nume, int nump, float m,Color3f color, BranchGroup master, List<Body> bodyList)
    {
        super(p,v,r,(float)(nump*Body.PROTON_CHARGE+nume*Body.ELECTRON_CHARGE),m,color,master,bodyList);
        numElectrons = nume;
        numProtons = nump;
    }
    public float getCharge(double d)
    {
        d = d*15.0;
        double eFraction = 1-Math.pow(Math.E, -(Math.pow(d,4)));
        return (float) (numProtons*Body.PROTON_CHARGE + numElectrons*eFraction*Body.ELECTRON_CHARGE);
    }
}
