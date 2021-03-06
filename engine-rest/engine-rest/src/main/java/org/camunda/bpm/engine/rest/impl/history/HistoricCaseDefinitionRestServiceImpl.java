/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.rest.impl.history;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.history.HistoricCaseActivityStatistics;
import org.camunda.bpm.engine.history.HistoricFinishedCaseInstanceReportResult;
import org.camunda.bpm.engine.rest.dto.history.HistoricCaseActivityStatisticsDto;
import org.camunda.bpm.engine.rest.dto.history.HistoricFinishedCaseInstanceReportDto;
import org.camunda.bpm.engine.rest.history.HistoricCaseDefinitionRestService;

/**
 * @author Roman Smirnov
 *
 */
public class HistoricCaseDefinitionRestServiceImpl implements HistoricCaseDefinitionRestService {

  protected ProcessEngine processEngine;

  public HistoricCaseDefinitionRestServiceImpl(ProcessEngine processEngine) {
    this.processEngine = processEngine;
  }

  public List<HistoricCaseActivityStatisticsDto> getHistoricCaseActivityStatistics(String caseDefinitionId) {
    HistoryService historyService = processEngine.getHistoryService();

    List<HistoricCaseActivityStatistics> statistics = historyService.createHistoricCaseActivityStatisticsQuery(caseDefinitionId).list();

    List<HistoricCaseActivityStatisticsDto> result = new ArrayList<HistoricCaseActivityStatisticsDto>();
    for (HistoricCaseActivityStatistics currentStatistics : statistics) {
      result.add(HistoricCaseActivityStatisticsDto.fromHistoricCaseActivityStatistics(currentStatistics));
    }

    return result;
  }

  @Override
  public List<HistoricFinishedCaseInstanceReportDto> getHistoricFinishedCaseInstanceReport() {
    HistoryService historyService = processEngine.getHistoryService();

    List<HistoricFinishedCaseInstanceReportResult> reportResult = historyService.createHistoricFinishedCaseInstanceReport().list();
    return HistoricFinishedCaseInstanceReportDto.convert(reportResult);
  }
}
