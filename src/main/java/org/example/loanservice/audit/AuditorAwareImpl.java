package org.example.loanservice.audit;

import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware<String> {
  @Override
  @NonNull
  public Optional<String> getCurrentAuditor() {
    return Optional.of("loan");
  }
}
