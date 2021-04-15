package com.mobiquity.packer.operation;

import com.mobiquity.packer.model.Package;
import com.mobiquity.packer.model.PackageResult;

/**
 * The interface Solver.
 */
public interface Solver {

    /**
     * Solve package.
     *
     * @param pack the pack
     * @return the package result
     */
    PackageResult solve(Package pack);

}
