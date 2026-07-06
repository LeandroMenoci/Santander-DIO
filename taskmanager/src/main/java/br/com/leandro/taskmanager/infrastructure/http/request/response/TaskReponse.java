package br.com.leandro.taskmanager.infrastructure.http.request.response;


import br.com.leandro.taskmanager.application.output.TaskOutput;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TaskReponse(String id, String title, String description, String status) {

    public static TaskReponse from(TaskOutput output) {
        return new TaskReponse(output.id(), output.title(), output.description().orElse(null), output.status());
    }
}
