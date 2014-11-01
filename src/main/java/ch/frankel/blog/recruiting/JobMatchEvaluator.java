package ch.frankel.blog.recruiting;

/*
 * #%L
 * Dear Recruiters
 * %%
 * Copyright (C) 2014 Nicolas Frankel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * #L%
 */


import static ch.frankel.blog.recruiting.ConferencePolicy.ACTIVELY_SENDING;
import static ch.frankel.blog.recruiting.TimePolicy.TWENTY_PERCENT_PET_PROJECT;
import static ch.frankel.blog.recruiting.TrainingPolicy.NOT_ONLY_SOFTWARE;
import static ch.frankel.blog.recruiting.TrainingPolicy.PROACTIVE;

public class JobMatchEvaluator {

    private final Company company;

    public JobMatchEvaluator(Company company) {
        this.company = company;
    }

    public InterestLevel evaluate() {
        if (!company.focusOnSoftware()
         || !company.investInPeople()
         || !company.staysUpToDate()
         || !company.allowsAnotherLife()
         || !company.respectCandidates()) {
            return InterestLevel.NONE;
        }
        InterestLevel interest = InterestLevel.NONE;
        if (company.getTraining() == PROACTIVE || company.getTraining() == NOT_ONLY_SOFTWARE) {
            interest = interest.increase();
        }
        if (company.getConference() == ACTIVELY_SENDING) {
            interest = interest.increase();
        }
        if (company.getTime() == TWENTY_PERCENT_PET_PROJECT) {
            interest = interest.increase();
        }
        return interest;
    }
}
