package org.biojava.nbio.structure.test;

import org.biojava.nbio.structure.Chain;
import org.biojava.nbio.structure.Group;
import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.align.util.AtomCache;
import org.biojava.nbio.structure.io.FileParsingParameters;
import org.biojava.nbio.structure.io.LocalPDBDirectory.FetchBehavior;

import junit.framework.TestCase;

public class Test1o2f extends TestCase{

	private static Structure structure = null;


	@Override
	protected void setUp() throws Exception {
		super.setUp();
		AtomCache cache = new AtomCache();
		cache.setUseMmCif(true);
		cache.setFetchBehavior(FetchBehavior.FETCH_FILES);
		FileParsingParameters params = cache.getFileParsingParams();
		params.setLoadChemCompInfo(true);
		params.setUseInternalChainId(true);
		cache.setFileParsingParams(params);
		StructureIO.setAtomCache(cache);
		String pdbId = "1O2F";
		structure = StructureIO.getStructure(pdbId);
	}


	public void test1a4wPDBFile(){
		for(int i=0;i<structure.nrModels();i++){
			for(Chain c: structure.getChains(i)){
				assertNotNull(c.getChainID());
				assertNotNull(c.getInternalChainID());
			}
		}
	}
}
