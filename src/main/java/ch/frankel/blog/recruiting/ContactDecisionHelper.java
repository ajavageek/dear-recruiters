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

public class ContactDecisionHelper {

    private final JobMatchEvaluator evaluator;
    private final Recruiter recruiter;

    public ContactDecisionHelper(JobMatchEvaluator evaluator, Recruiter recruiter) {
        this.evaluator = evaluator;
        this.recruiter = recruiter;
    }

    public boolean shouldContact() {
        if (!recruiter.canDiscloseDetails()) {
            return false;
        }
        InterestLevel interest = evaluator.evaluate();
        switch(interest) {
            case NOT_ENOUGH:
            case NONE:
                return false;
            case TOTAL:
            case SPARKED:
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
