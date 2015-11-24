/*
 * Copyright (C) 2014-2015 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 */

package gobblin.data.management.retention.dataset.finder;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.fs.Path;

import gobblin.data.management.dataset.Dataset;


/**
 * Finds {@link gobblin.data.management.retention.dataset.CleanableDataset}s in the file system.
 *
 * <p>
 *   Concrete subclasses should have a constructor with signature
 *   ({@link org.apache.hadoop.fs.FileSystem}, {@link java.util.Properties}).
 * </p>
 */
public interface DatasetFinder <T extends Dataset>{

  /**
   * Find all {@link gobblin.data.management.retention.dataset.CleanableDataset}s in the file system.
   * @return List of {@link gobblin.data.management.retention.dataset.CleanableDataset}s in the file system.
   * @throws IOException
   */
  public List<T> findDatasets() throws IOException;

  /**
   * @return The deepest common root shared by all all {@link Dataset} root paths returned by this finder.
   */
  public Path commonDatasetRoot();

}
